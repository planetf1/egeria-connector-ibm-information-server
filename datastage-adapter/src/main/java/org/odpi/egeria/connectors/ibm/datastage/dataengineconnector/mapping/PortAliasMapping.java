/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.datastage.dataengineconnector.mapping;

import org.odpi.egeria.connectors.ibm.datastage.dataengineconnector.model.DataStageCache;
import org.odpi.egeria.connectors.ibm.datastage.dataengineconnector.model.DataStageJob;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestClient;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base.Dsjob;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base.InformationAsset;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.base.Stage;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.common.ItemList;
import org.odpi.openmetadata.accessservices.dataengine.model.PortAlias;
import org.odpi.openmetadata.accessservices.dataengine.model.PortType;
import org.odpi.openmetadata.accessservices.dataengine.model.Process;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Mappings for creating a set of PortAliases.
 */
class PortAliasMapping extends BaseMapping {

    private static final Logger log = LoggerFactory.getLogger(PortAliasMapping.class);

    private Set<PortAlias> portAliases;

    private PortAliasMapping(DataStageCache cache) {
        super(cache);
        portAliases = new HashSet<>();
    }

    /**
     * Create a list of PortAliases from the provided job and stage information.
     *
     * @param cache used by this mapping
     * @param job the job for which to create PortAliases
     * @param stages the stages from which to create PortAliases
     * @param portType the type of port to map (input or output)
     */
    PortAliasMapping(DataStageCache cache, DataStageJob job, List<Stage> stages, PortType portType) {

        this(cache);

        for (Stage stage : stages) {
            if (portType.equals(PortType.INPUT_PORT)) {
                addInputPortAliases(job, stage);
            } else if (portType.equals(PortType.OUTPUT_PORT)) {
                addOutputPortAliases(job, stage);
            }
        }

    }

    /**
     * Create a list of PortAliases from the provided sequence job.
     *
     * @param cache used by this mapping
     * @param sequence the sequence for which to create PortAliases
     */
    PortAliasMapping(DataStageCache cache, DataStageJob sequence) {

        this(cache);

        if (sequence.getType().equals(DataStageJob.JobType.SEQUENCE)) {
            for (Stage stage : sequence.getAllStages()) {
                Dsjob runsJob = stage.getRunsSequencesJobs();
                if (runsJob != null) {
                    String jobId = runsJob.getId();
                    if (jobId != null) {
                        Process jobProcess = cache.getProcessByRid(jobId);

                        if (jobProcess != null) {
                            List<PortAlias> jobPortAliases = jobProcess.getPortAliases();
                            // Create a new PortAlias at the sequence level, for each underlying PortAlias of jobs
                            // that are executed, that delegateTo the underlying job's PortAlias
                            for (PortAlias delegateTo : jobPortAliases) {
                                String stageQN = getFullyQualifiedName(stage);
                                if (stageQN != null) {
                                    PortAlias sequencePortAlias = getSkeletonPortAlias(stageQN + "::" + delegateTo.getQualifiedName(), stage.getName() + "_" + delegateTo.getDisplayName());
                                    sequencePortAlias.setPortType(delegateTo.getPortType());
                                    sequencePortAlias.setDelegatesTo(delegateTo.getQualifiedName());
                                    portAliases.add(sequencePortAlias);
                                } else {
                                    log.error("Unable to determine identity for stage -- not including: {}", stage);
                                }
                            }
                        } else {
                            log.warn("Unable to find existing process to use for alias: {}", jobId);
                        }
                    }
                }
            }
        }

    }

    /**
     * Retrieve the PortAliases that were setup.
     *
     * @return {@code List<PortAlias>}
     */
    List<PortAlias> getPortAliases() { return new ArrayList<>(portAliases); }

    private void addInputPortAliases(DataStageJob job, Stage stage) {
        addPortAliases(job, stage, "reads_from_(design)", stage.getReadsFromDesign(), PortType.INPUT_PORT);
    }

    private void addOutputPortAliases(DataStageJob job, Stage stage) {
        addPortAliases(job, stage, "writes_to_(design)", stage.getWritesToDesign(), PortType.OUTPUT_PORT);
    }

    private void addPortAliases(DataStageJob job, Stage stage, String propertyName, ItemList<InformationAsset> relations, PortType portType) {
        List<InformationAsset> allRelations = igcRestClient.getAllPages(propertyName, relations);
        for (InformationAsset relation : allRelations) {
            String fullyQualifiedStoreName = cache.getQualifiedNameFromStoreRid(relation.getId());
            String fullyQualifiedStageName = getFullyQualifiedName(stage);
            PortAlias portAlias = getSkeletonPortAlias(fullyQualifiedStageName, stage.getName());
            portAlias.setPortType(portType);
            portAlias.setDelegatesTo(fullyQualifiedStoreName + fullyQualifiedStageName);
            portAliases.add(portAlias);
        }
    }

    private PortAlias getSkeletonPortAlias(String qualifiedName, String displayName) {
        PortAlias portAlias = new PortAlias();
        portAlias.setQualifiedName(qualifiedName);
        portAlias.setDisplayName(displayName);
        return portAlias;
    }

}
