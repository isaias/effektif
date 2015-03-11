/*
 * Copyright 2014 Effektif GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.effektif.workflow.api.model;

import java.util.LinkedHashMap;
import java.util.Map;

import com.effektif.workflow.api.form.FormInstance;
import com.effektif.workflow.api.workflow.Workflow;


/**
 * The runtime representation of a {@link com.effektif.workflow.api.workflow.Trigger}
 * when executing a workflow.
 *
 * @author Tom Baeyens
 */
public class TriggerInstance {
  
  protected String workflowInstanceId;
  protected String workflowId;
  protected String sourceWorkflowId;
  protected String businessKey;
  protected Map<String,Object> data;
  protected String caseId;
  protected String callerWorkflowInstanceId;
  protected String callerActivityInstanceId;

  public String getWorkflowId() {
    return this.workflowId;
  }
  public void setWorkflowId(String workflowId) {
    this.workflowId = workflowId;
  }

  /** use this specific workflow version. 
   * If you want to use the latest version of a certain workflow, use {@link #sourceWorkflowId(String)}. */
  public TriggerInstance workflowId(String workflowId) {
    this.workflowId = workflowId;
    return this;
  }
  
  public String getSourceWorkflowId() {
    return this.sourceWorkflowId;
  }
  public void setSourceWorkflowId(String sourceWorkflowId) {
    this.sourceWorkflowId = sourceWorkflowId;
  }
  
  /** use the lastest version of the workflow for the given source.
   * @see Workflow#sourceWorkflowId(String) */
  public TriggerInstance sourceWorkflowId(String sourceWorkflowId) {
    this.sourceWorkflowId = sourceWorkflowId;
    return this;
  }

  public Map<String,Object> getData() {
    return this.data;
  }

  /** @see #data(String, Object) */
  public void setData(Map<String,Object> data) {
    this.data = data;
  }

  /** this data is passed to the trigger or is set as variable values.
   * In case there is no trigger specified, the data keys have to 
   * represent the variable ids. */
  public TriggerInstance data(String key, Object value) {
    if (data==null) {
      data = new LinkedHashMap<>();
    }
    data.put(key, value);
    return this;
  }
  /** retrieves a data item from the map */
  public Object getData(String key) {
    return data!=null ? data.get(key) : null;
  }

  
  public String getBusinessKey() {
    return this.businessKey;
  }
  public void setBusinessKey(String businessKey) {
    this.businessKey = businessKey;
  }

  /**
   * Optional user-defined unique ID (unique in the scope of one workflow).
   */
  public TriggerInstance businessKey(String businessKey) {
    this.businessKey = businessKey;
    return this;
  }

  /**
   * Optional ID that is passed.
   * Please be aware that worklfowInstanceIds are normally assigned by 
   * the (persistence implementation in the) engine.
   * You can provide your own here but please be aware that it 
   * might have to be compatible with the persistence implementation.
   */
  public String getWorkflowInstanceId() {
    return this.workflowInstanceId;
  }
  public void setWorkflowInstanceId(String workflowInstanceId) {
    this.workflowInstanceId = workflowInstanceId;
  }

  /** references the top-level-task (aka case) that is related to the 
   * created workflow instance. */
  public String getCaseId() {
    return this.caseId;
  }
  /** references the top-level-task (aka case) that is related to the 
   * created workflow instance. */
  public void setCaseId(String caseId) {
    this.caseId = caseId;
  }
  
  /** used by the call activity to establish the link between the calling activity instance 
   * and the called workflow instance */
  public String getCallerWorkflowInstanceId() {
    return callerWorkflowInstanceId;
  }
  
  /** used by the call activity to establish the link between the calling activity instance 
   * and the called workflow instance */
  public void setCallerWorkflowInstanceId(String callerWorkflowInstanceId) {
    this.callerWorkflowInstanceId = callerWorkflowInstanceId;
  }
  
  /** used by the call activity to establish the link between the calling activity instance 
   * and the called workflow instance */
  public String getCallerActivityInstanceId() {
    return callerActivityInstanceId;
  }

  /** used by the call activity to establish the link between the calling activity instance 
   * and the called workflow instance */
  public void setCallerActivityInstanceId(String callerActivityInstanceId) {
    this.callerActivityInstanceId = callerActivityInstanceId;
  }
}
