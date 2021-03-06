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
package com.effektif.workflow.impl.activity.types;

import com.effektif.workflow.api.activities.NoneTask;
import com.effektif.workflow.api.xml.XmlElement;
import com.effektif.workflow.impl.activity.AbstractActivityType;
import com.effektif.workflow.impl.bpmn.BpmnReader;
import com.effektif.workflow.impl.bpmn.BpmnWriter;
import com.effektif.workflow.impl.workflowinstance.ActivityInstanceImpl;


/** this task doesn't do anything, it just continues (aka no-op, pass-through). */
public class NoneTaskImpl extends AbstractActivityType<NoneTask> {

  private static final String BPMN_ELEMENT_NAME = "task";

  public NoneTaskImpl() {
    super(NoneTask.class);
  }

  @Override
  public NoneTask readBpmn(XmlElement xml, BpmnReader reader) {
    if (!reader.isLocalPart(xml, BPMN_ELEMENT_NAME)) {
      return null;
    }
    NoneTask task = new NoneTask();
    return task;
  }

  @Override
  public void writeBpmn(NoneTask task, XmlElement xml, BpmnWriter writer) {
    writer.setBpmnName(xml, BPMN_ELEMENT_NAME);
    writer.writeBpmnAttribute(xml, "id", task.getId());
  }

  @Override
  public void execute(ActivityInstanceImpl activityInstance) {
    activityInstance.onwards();
  }

  @Override
  public boolean isFlushSkippable() {
    return true;
  }
}
