/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.container.impl.jmx.services;

import org.camunda.bpm.container.impl.jmx.kernel.MBeanServiceContainer;
import org.camunda.bpm.engine.ProcessEngineConfiguration;

/**
 * <p>Represents a managed process engine that is started / stopped inside the {@link MBeanServiceContainer}</p>
 * 
 * @author Daniel Meyer
 *
 */
public class JmxManagedProcessEngineController extends JmxManagedProcessEngine implements JmxManagedProcessEngineMBean {
  
  protected ProcessEngineConfiguration processEngineConfiguration;
  
  public JmxManagedProcessEngineController(ProcessEngineConfiguration processEngineConfiguration) {
    this.processEngineConfiguration = processEngineConfiguration;
  }
  
  public void start(MBeanServiceContainer contanier) {
    processEngine = processEngineConfiguration.buildProcessEngine();
  }
  
  public void stop(MBeanServiceContainer container) {
    processEngine.close();
  }
  
}
