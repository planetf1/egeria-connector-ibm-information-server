/* SPDX-License-Identifier: Apache-2.0 */
/* Copyright Contributors to the ODPi Egeria project. */
package org.odpi.egeria.connectors.ibm.igc.clientlibrary.mocks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.IGCRestClient;
import org.odpi.egeria.connectors.ibm.igc.clientlibrary.model.types.TypeDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MockIGCClient provides a concrete IGCRestClient object to test various client-related methods.
 */
public class MockIGCClient extends IGCRestClient {

    private static final Logger log = LoggerFactory.getLogger(MockIGCClient.class);

    private static final String TERM_TYPE_DETAILS = "{\"editInfo\":{\"sections\":[{\"displayName\":\"Header\",\"name\":\"Header\",\"properties\":[\"name\",\"short_description\",\"long_description\",\"parent_category\",\"referencing_categories\",\"labels\",\"stewards\",\"status\",\"governed_by_rules\",\"language\"]},{\"displayName\":\"General Information\",\"name\":\"General Information\",\"properties\":[\"abbreviation\",\"additional_abbreviation\",\"example\",\"usage\",\"is_modifier\",\"type\",\"translations\"]},{\"displayName\":\"Associated Terms\",\"name\":\"Associated Terms\",\"properties\":[\"is_a_type_of\",\"has_types\",\"is_of\",\"has_a_term\",\"synonyms\",\"preferred_synonym\",\"related_terms\",\"replaces\",\"replaced_by\",\"assigned_terms\",\"assigned_to_terms\"]},{\"displayName\":\"Assigned Assets\",\"name\":\"Assigned Assets\",\"properties\":[\"assigned_assets\"]},{\"displayName\":\"Notes\",\"name\":\"Notes\",\"properties\":[\"notes\"]}],\"properties\":[{\"minCardinality\":1,\"displayName\":\"Name\",\"name\":\"name\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Short Description\",\"name\":\"short_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Long Description\",\"name\":\"long_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"minCardinality\":1,\"displayName\":\"Parent Category\",\"name\":\"parent_category\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"},\"maxCardinality\":1},{\"displayName\":\"Referencing Categories\",\"name\":\"referencing_categories\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Labels\",\"name\":\"labels\",\"type\":{\"name\":\"label\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/label\"}},{\"displayName\":\"Stewards\",\"name\":\"stewards\",\"type\":{\"name\":\"ascl_steward\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/ascl_steward\"}},{\"minCardinality\":1,\"displayName\":\"Status\",\"name\":\"status\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"Candidate\",\"id\":\"CANDIDATE\"},{\"displayName\":\"Accepted\",\"id\":\"ACCEPTED\"},{\"displayName\":\"Standard\",\"id\":\"STANDARD\"},{\"displayName\":\"Deprecated\",\"id\":\"DEPRECATED\"}]},\"maxCardinality\":1},{\"displayName\":\"Governed by Rules\",\"name\":\"governed_by_rules\",\"type\":{\"name\":\"information_governance_rule\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/information_governance_rule\"}},{\"displayName\":\"Language\",\"name\":\"language\",\"type\":{\"name\":\"enum\",\"validValues\":[]},\"maxCardinality\":1},{\"displayName\":\"Abbreviation\",\"name\":\"abbreviation\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Additional Abbreviation\",\"name\":\"additional_abbreviation\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Example\",\"name\":\"example\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Usage\",\"name\":\"usage\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Is Modifier\",\"name\":\"is_modifier\",\"type\":{\"name\":\"boolean\"},\"maxCardinality\":1},{\"displayName\":\"Type\",\"name\":\"type\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"None\",\"id\":\"NONE\"},{\"displayName\":\"Primary\",\"id\":\"PRIME\"},{\"displayName\":\"Secondary\",\"id\":\"CLASS\"}]},\"maxCardinality\":1},{\"displayName\":\"Translations\",\"name\":\"translations\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Is a Type Of\",\"name\":\"is_a_type_of\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Has Types\",\"name\":\"has_types\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Is Of\",\"name\":\"is_of\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Has A\",\"name\":\"has_a_term\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Synonyms\",\"name\":\"synonyms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Preferred Synonym\",\"name\":\"preferred_synonym\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"},\"maxCardinality\":1},{\"displayName\":\"Related Terms\",\"name\":\"related_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Replaces\",\"name\":\"replaces\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Replaced By\",\"name\":\"replaced_by\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"},\"maxCardinality\":1},{\"displayName\":\"Assigned Terms\",\"name\":\"assigned_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Assigned to Terms\",\"name\":\"assigned_to_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Assigned Assets\",\"name\":\"assigned_assets\",\"type\":{\"name\":\"information_asset\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/information_asset\"},\"permitted_types\":[\"jobdef\",\"mdm_model\",\"logical_variable\",\"published_data_rule_definition\",\"reference_key\",\"data_file_definition_field\",\"logical_foreign_key\",\"data_rule\",\"xsd_simple_type\",\"column_analysis_summary\",\"data_file_folder_nobucket\",\"user_role\",\"xsd_element_group_reference\",\"information_server_report_param_(job)\",\"input_parameter\",\"inout_parameter\",\"stage_type_detail\",\"parameter_set_definition\",\"data_file_field\",\"r_shiny_app_object\",\"valid_value_list\",\"parameterset\",\"non_published_data_rule_set\",\"data_file_folder\",\"inferred_key\",\"idoc_field\",\"data_class_old\",\"bi_collection_member\",\"volume\",\"xsd_foreign_key\",\"physical_data_model\",\"analytics_object\",\"information_server_report_(analysis_project)\",\"directory\",\"information_governance_rule\",\"transform_argument\",\"label\",\"stored_procedure\",\"design_column\",\"filterconstraint\",\"system_role\",\"bi_report_query_detail_filter\",\"connector\",\"extension_mapping\",\"candidate_key\",\"mapping_component\",\"bi_report_nocontext\",\"tuple\",\"automation_rule\",\"local_container\",\"stage_type\",\"standardization_rule\",\"physical_domain\",\"database_index\",\"data_connection\",\"valid_value_range\",\"non_published_data_rule_definition\",\"function\",\"out_parameter\",\"table_analysis_summary\",\"data_rule_set_definition\",\"$OMRS-Stub\",\"subject_area\",\"bi_report_data_item_source\",\"information_server_report\",\"xsd_element_group\",\"xsd_element\",\"bi_report_query_item\",\"design_table\",\"olapassociation\",\"application\",\"host_(engine)\",\"sap_connection\",\"data_file_definition_record\",\"sequence_job\",\"ds_stage_column\",\"stored_procedure_parameter\",\"data_rule_set\",\"xsd_unique_key\",\"endpoint\",\"routine\",\"logical_validation_rule\",\"attribute\",\"metric\",\"bi_report_section\",\"bi_collection\",\"view\",\"job_stage_record\",\"bi_report_query_summary_filter\",\"data_file\",\"tuple_attribute\",\"extension_mapping_document\",\"design_view\",\"design_stored_procedure\",\"logical_key\",\"olap_join\",\"physical_object_attribute\",\"idoc_segment_type\",\"result_column\",\"xsd_sequence\",\"dsjcltemplate\",\"entity_attribute\",\"infoset\",\"data_class\",\"inferred_foreign_key\",\"shared_container\",\"standardization_object\",\"bi_server\",\"routine_argument\",\"hbase_namespace\",\"bi_report_query_usage\",\"valid_value\",\"data_rule_results\",\"inv_data_rule_set\",\"amazon_s3_data_file_folder\",\"published_data_rule_set\",\"r_shiny_app\",\"parameter_set\",\"lineage_container\",\"information_services_project\",\"bi_olap_level_element\",\"job\",\"xsd_primary_key\",\"reportobject\",\"database\",\"datagroup\",\"design_foreign_key\",\"table_analysis\",\"logical_domain\",\"stage_column\",\"data_field\",\"logical_data_model\",\"root_tuple\",\"standardization_rule_set\",\"field_analysis\",\"bi_folder\",\"dsparameter_job\",\"xsd_complex_type\",\"term\",\"logical_inversion_key\",\"validity_table\",\"stage\",\"analytics_model\",\"output_value\",\"data_file_record\",\"design_stored_procedure_parameter\",\"xsd_attribute_reference\",\"xsd_choice\",\"application_install\",\"database_domain\",\"logical_entity\",\"data_rule_definition\",\"data_item\",\"in_parameter\",\"logical_validation_list\",\"inv_data_rule_definition\",\"bi_hierarchy\",\"information_services_application\",\"dsparameter\",\"database_table\",\"mapping_project\",\"xsd_attribute\",\"analysis_project\",\"olaphierarchyassociation\",\"classificationenabledgroup\",\"file\",\"database_schema\",\"analytics_project\",\"bi_filter\",\"dsjob\",\"inv_data_rule_set_definition\",\"instance\",\"match_specification\",\"bi_report_nofolder\",\"database_column\",\"attribute_type_field\",\"bi_cube\",\"host\",\"physical_object\",\"foreign_key\",\"olapobject\",\"analysissummaryobject\",\"logical_validation_range\",\"information_governance_policy\",\"attribute_type\",\"data_item_value\",\"amazon_s3_bucket\",\"column_analysis\",\"design_key\",\"bi_report_query\",\"analytics_script\",\"information_server_report_(steward)\",\"amazon_s3_data_file_field\",\"information_server_report_(job)\",\"amazon_s3_data_file\",\"information_server_report_(mapping_specification)\",\"entity_type\",\"olapmodelgroup\",\"amazon_s3_data_file_record\",\"database_alias\",\"file_record_analysis\",\"bi_collection_fact\",\"stage_variable\",\"collection\",\"bi_root_folder\",\"inv_data_rule\",\"column_definition\",\"dsdesign_view\",\"xsd_element_reference\",\"bi_collection_dimension\",\"bi_hierarchy_member\",\"composite_view\",\"referenced_container\",\"dsparameter_set\",\"method\",\"olap_member_source\",\"bi_level\",\"bi_report\",\"information_server_report_(database)\",\"filter\",\"idoc_type\",\"dsstage_type\",\"stored_procedure_definition\",\"information_server_report_(mapping_project)\",\"lineage_report_template\",\"table_definition\",\"olapjoinref\",\"notebook\",\"xsd_attribute_group\",\"transforms_function\",\"job_constraint\",\"bi_model\",\"member_type\",\"link\",\"data_element\",\"dsdata_connection\",\"array\",\"parameter\",\"object_type\",\"data_file_definition\",\"data_item_definition\",\"xml_schema_definition\",\"derivation\",\"mapping_specification\",\"category\"]},{\"displayName\":\"Notes\",\"name\":\"notes\",\"type\":{\"name\":\"note\"}}]},\"_businessLineage\":false,\"viewInfo\":{\"sections\":[{\"displayName\":\"Header\",\"name\":\"Header\",\"properties\":[\"name\",\"short_description\",\"long_description\",\"parent_category\",\"category_path\",\"referencing_categories\",\"labels\",\"stewards\",\"status\",\"governed_by_rules\",\"language\"]},{\"displayName\":\"General Information\",\"name\":\"General Information\",\"properties\":[\"abbreviation\",\"additional_abbreviation\",\"example\",\"usage\",\"is_modifier\",\"type\",\"translations\",\"native_id\"]},{\"displayName\":\"Associated Terms\",\"name\":\"Associated Terms\",\"properties\":[\"is_a_type_of\",\"has_types\",\"is_of\",\"has_a\",\"has_a_term\",\"synonyms\",\"preferred_synonym\",\"related_terms\",\"replaces\",\"replaced_by\",\"assigned_terms\",\"assigned_to_terms\"]},{\"displayName\":\"Assigned Assets\",\"name\":\"Assigned Assets\",\"properties\":[\"assigned_assets\",\"Automation_Rules\"]},{\"displayName\":\"In Collections\",\"name\":\"In Collections\",\"properties\":[\"in_collections\"]},{\"displayName\":\"Notes\",\"name\":\"Notes\",\"properties\":[\"notes\"]},{\"displayName\":\"Workflow State\",\"name\":\"Workflow State\",\"properties\":[\"workflow_current_state\",\"workflow_stored_state\",\"glossary_type\"]},{\"displayName\":\"Modification Details\",\"name\":\"Modification Details\",\"properties\":[\"created_by\",\"created_on\",\"modified_by\",\"modified_on\"]}],\"properties\":[{\"minCardinality\":1,\"displayName\":\"Name\",\"name\":\"name\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Short Description\",\"name\":\"short_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Long Description\",\"name\":\"long_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"minCardinality\":1,\"displayName\":\"Parent Category\",\"name\":\"parent_category\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"},\"maxCardinality\":1},{\"displayName\":\"Category Path\",\"name\":\"category_path\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Referencing Categories\",\"name\":\"referencing_categories\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Labels\",\"name\":\"labels\",\"type\":{\"name\":\"label\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/label\"}},{\"displayName\":\"Stewards\",\"name\":\"stewards\",\"type\":{\"name\":\"ascl_steward\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/ascl_steward\"}},{\"minCardinality\":1,\"displayName\":\"Status\",\"name\":\"status\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"Candidate\",\"id\":\"CANDIDATE\"},{\"displayName\":\"Accepted\",\"id\":\"ACCEPTED\"},{\"displayName\":\"Standard\",\"id\":\"STANDARD\"},{\"displayName\":\"Deprecated\",\"id\":\"DEPRECATED\"}]},\"maxCardinality\":1},{\"displayName\":\"Governed by Rules\",\"name\":\"governed_by_rules\",\"type\":{\"name\":\"information_governance_rule\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/information_governance_rule\"}},{\"displayName\":\"Language\",\"name\":\"language\",\"type\":{\"name\":\"enum\",\"validValues\":[]},\"maxCardinality\":1},{\"displayName\":\"Abbreviation\",\"name\":\"abbreviation\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Additional Abbreviation\",\"name\":\"additional_abbreviation\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Example\",\"name\":\"example\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Usage\",\"name\":\"usage\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Is Modifier\",\"name\":\"is_modifier\",\"type\":{\"name\":\"boolean\"},\"maxCardinality\":1},{\"displayName\":\"Type\",\"name\":\"type\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"None\",\"id\":\"NONE\"},{\"displayName\":\"Primary\",\"id\":\"PRIME\"},{\"displayName\":\"Secondary\",\"id\":\"CLASS\"}]},\"maxCardinality\":1},{\"displayName\":\"Translations\",\"name\":\"translations\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Native ID\",\"name\":\"native_id\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Is a Type Of\",\"name\":\"is_a_type_of\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Has Types\",\"name\":\"has_types\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Is Of\",\"name\":\"is_of\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Has A\",\"name\":\"has_a\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"},\"maxCardinality\":1},{\"displayName\":\"Has A\",\"name\":\"has_a_term\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Synonyms\",\"name\":\"synonyms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Preferred Synonym\",\"name\":\"preferred_synonym\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"},\"maxCardinality\":1},{\"displayName\":\"Related Terms\",\"name\":\"related_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Replaces\",\"name\":\"replaces\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Replaced By\",\"name\":\"replaced_by\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"},\"maxCardinality\":1},{\"displayName\":\"Assigned Terms\",\"name\":\"assigned_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Assigned to Terms\",\"name\":\"assigned_to_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Assigned Assets\",\"name\":\"assigned_assets\",\"type\":{\"name\":\"information_asset\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/information_asset\"}},{\"displayName\":\"Automation Rules\",\"name\":\"Automation_Rules\",\"type\":{\"name\":\"main_object\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/main_object\"}},{\"displayName\":\"In Collections\",\"name\":\"in_collections\",\"type\":{\"name\":\"collection\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/collection\"}},{\"displayName\":\"Notes\",\"name\":\"notes\",\"type\":{\"name\":\"note\"}},{\"displayName\":\"Workflow Current State\",\"name\":\"workflow_current_state\",\"type\":{\"name\":\"string\"}},{\"displayName\":\"Workflow Stored State\",\"name\":\"workflow_stored_state\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"DRAFT\",\"id\":\"DRAFT\"},{\"displayName\":\"WAITING_APPROVAL\",\"id\":\"WAITING_APPROVAL\"},{\"displayName\":\"APPROVED\",\"id\":\"APPROVED\"}]}},{\"displayName\":\"Glossary Type\",\"name\":\"glossary_type\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"PUBLISHED\",\"id\":\"PUBLISHED\"},{\"displayName\":\"DRAFT\",\"id\":\"DRAFT\"}]},\"maxCardinality\":1},{\"displayName\":\"Created By\",\"name\":\"created_by\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Created On\",\"name\":\"created_on\",\"type\":{\"name\":\"datetime\"},\"maxCardinality\":1},{\"displayName\":\"Modified By\",\"name\":\"modified_by\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Modified On\",\"name\":\"modified_on\",\"type\":{\"name\":\"datetime\"},\"maxCardinality\":1}]},\"_name\":\"Term\",\"_plural\":\"Terms\",\"_id\":\"term\",\"_class\":\"GlossaryExtensions.BusinessTerm\",\"_url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\",\"_dataLineage\":false,\"_group\":\"Glossary and Governance\",\"createInfo\":{\"properties\":[{\"minCardinality\":1,\"displayName\":\"Name\",\"name\":\"name\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"minCardinality\":1,\"displayName\":\"Parent Category\",\"name\":\"parent_category\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"},\"maxCardinality\":1},{\"displayName\":\"Short Description\",\"name\":\"short_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"minCardinality\":1,\"displayName\":\"Status\",\"name\":\"status\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"Candidate\",\"id\":\"CANDIDATE\"},{\"displayName\":\"Accepted\",\"id\":\"ACCEPTED\"},{\"displayName\":\"Standard\",\"id\":\"STANDARD\"},{\"displayName\":\"Deprecated\",\"id\":\"DEPRECATED\"}]},\"maxCardinality\":1},{\"displayName\":\"Native ID\",\"name\":\"native_id\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1}]},\"_parents\":[\"information_asset\"]}";
    private static final String CATEGORY_TYPE_DETAILS = "{\"editInfo\":{\"sections\":[{\"displayName\":\"Header\",\"name\":\"Header\",\"properties\":[\"name\",\"short_description\",\"long_description\",\"parent_category\",\"labels\",\"stewards\",\"assigned_to_terms\",\"language\"]},{\"displayName\":\"Subcategories\",\"name\":\"Subcategories\",\"properties\":[\"subcategories\"]},{\"displayName\":\"Terms\",\"name\":\"Terms\",\"properties\":[\"contains_business_term\",\"references_business_term\"]},{\"displayName\":\"Notes\",\"name\":\"Notes\",\"properties\":[\"notes\"]}],\"properties\":[{\"minCardinality\":1,\"displayName\":\"Name\",\"name\":\"name\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Short Description\",\"name\":\"short_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Long Description\",\"name\":\"long_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Parent Category\",\"name\":\"parent_category\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"},\"maxCardinality\":1},{\"displayName\":\"Labels\",\"name\":\"labels\",\"type\":{\"name\":\"label\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/label\"}},{\"displayName\":\"Stewards\",\"name\":\"stewards\",\"type\":{\"name\":\"ascl_steward\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/ascl_steward\"}},{\"displayName\":\"Assigned to Terms\",\"name\":\"assigned_to_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Language\",\"name\":\"language\",\"type\":{\"name\":\"enum\",\"validValues\":[]},\"maxCardinality\":1},{\"displayName\":\"Subcategories\",\"name\":\"subcategories\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Contains Business Terms\",\"name\":\"contains_business_term\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"References Business Terms\",\"name\":\"references_business_term\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Notes\",\"name\":\"notes\",\"type\":{\"name\":\"note\"}}]},\"_businessLineage\":false,\"viewInfo\":{\"sections\":[{\"displayName\":\"Header\",\"name\":\"Header\",\"properties\":[\"name\",\"short_description\",\"long_description\",\"parent_category\",\"category_path\",\"labels\",\"stewards\",\"assigned_to_terms\",\"language\"]},{\"displayName\":\"General Information\",\"name\":\"General Information\",\"properties\":[\"translations\",\"native_id\"]},{\"displayName\":\"Subcategories\",\"name\":\"Subcategories\",\"properties\":[\"subcategories\"]},{\"displayName\":\"Terms\",\"name\":\"Terms\",\"properties\":[\"terms\"]},{\"displayName\":\"In Collections\",\"name\":\"In Collections\",\"properties\":[\"in_collections\"]},{\"displayName\":\"Notes\",\"name\":\"Notes\",\"properties\":[\"notes\"]},{\"displayName\":\"Workflow State\",\"name\":\"Workflow State\",\"properties\":[\"workflow_current_state\",\"workflow_stored_state\",\"glossary_type\"]},{\"displayName\":\"Modification Details\",\"name\":\"Modification Details\",\"properties\":[\"created_by\",\"created_on\",\"modified_by\",\"modified_on\"]}],\"properties\":[{\"minCardinality\":1,\"displayName\":\"Name\",\"name\":\"name\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Short Description\",\"name\":\"short_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Long Description\",\"name\":\"long_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Parent Category\",\"name\":\"parent_category\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"},\"maxCardinality\":1},{\"displayName\":\"Category Path\",\"name\":\"category_path\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Labels\",\"name\":\"labels\",\"type\":{\"name\":\"label\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/label\"}},{\"displayName\":\"Stewards\",\"name\":\"stewards\",\"type\":{\"name\":\"ascl_steward\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/ascl_steward\"}},{\"displayName\":\"Assigned to Terms\",\"name\":\"assigned_to_terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"Language\",\"name\":\"language\",\"type\":{\"name\":\"enum\",\"validValues\":[]},\"maxCardinality\":1},{\"displayName\":\"Translations\",\"name\":\"translations\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Native ID\",\"name\":\"native_id\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Subcategories\",\"name\":\"subcategories\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"}},{\"displayName\":\"Terms\",\"name\":\"terms\",\"type\":{\"name\":\"term\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/term\"}},{\"displayName\":\"In Collections\",\"name\":\"in_collections\",\"type\":{\"name\":\"collection\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/collection\"}},{\"displayName\":\"Notes\",\"name\":\"notes\",\"type\":{\"name\":\"note\"}},{\"displayName\":\"Workflow Current State\",\"name\":\"workflow_current_state\",\"type\":{\"name\":\"string\"}},{\"displayName\":\"Workflow Stored State\",\"name\":\"workflow_stored_state\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"DRAFT\",\"id\":\"DRAFT\"},{\"displayName\":\"WAITING_APPROVAL\",\"id\":\"WAITING_APPROVAL\"},{\"displayName\":\"APPROVED\",\"id\":\"APPROVED\"}]}},{\"displayName\":\"Glossary Type\",\"name\":\"glossary_type\",\"type\":{\"name\":\"enum\",\"validValues\":[{\"displayName\":\"PUBLISHED\",\"id\":\"PUBLISHED\"},{\"displayName\":\"DRAFT\",\"id\":\"DRAFT\"}]},\"maxCardinality\":1},{\"displayName\":\"Created By\",\"name\":\"created_by\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Created On\",\"name\":\"created_on\",\"type\":{\"name\":\"datetime\"},\"maxCardinality\":1},{\"displayName\":\"Modified By\",\"name\":\"modified_by\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Modified On\",\"name\":\"modified_on\",\"type\":{\"name\":\"datetime\"},\"maxCardinality\":1}]},\"_name\":\"Category\",\"_plural\":\"Categories\",\"_id\":\"category\",\"_class\":\"GlossaryExtensions.BusinessCategory\",\"_url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\",\"_dataLineage\":false,\"_group\":\"Glossary and Governance\",\"createInfo\":{\"properties\":[{\"minCardinality\":1,\"displayName\":\"Name\",\"name\":\"name\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Parent Category\",\"name\":\"parent_category\",\"type\":{\"name\":\"category\",\"url\":\"https://infosvr:9446/ibm/iis/igc-rest/v1/types/category\"},\"maxCardinality\":1},{\"displayName\":\"Short Description\",\"name\":\"short_description\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1},{\"displayName\":\"Native ID\",\"name\":\"native_id\",\"type\":{\"name\":\"string\"},\"maxCardinality\":1}]},\"_parents\":[\"information_asset\"]}";

    private ObjectMapper mockMapper;

    public MockIGCClient() {
        super("localhost", "8080", "nouser", "nopassword");
        mockMapper = new ObjectMapper();
    }

    @Override
    public TypeDetails getTypeDetails(String typeName) {
        TypeDetails typeDetails = null;
        try {
            switch (typeName) {
                case "term":
                    typeDetails = mockMapper.readValue(TERM_TYPE_DETAILS, TypeDetails.class);
                    break;
                case "category":
                    typeDetails = mockMapper.readValue(CATEGORY_TYPE_DETAILS, TypeDetails.class);
                    break;
                default:
                    log.error("Have not mocked up the requested type: {}", typeName);
                    break;
            }
        } catch (JsonProcessingException e) {
            log.error("Unable to parse type details.", e);
        }
        return typeDetails;
    }

}
