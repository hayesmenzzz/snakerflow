/* Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snaker.engine.spring;

import org.snaker.engine.SnakerEngine;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SnakerEngine运行于spring环境的FactoryBean实现类，用于产生单例的SnakerEngine实例
 * @author yuqs
 * @version 1.0
 */
public class SnakerEngineFactoryBean implements FactoryBean<SnakerEngine>, ApplicationContextAware {
	protected ApplicationContext applicationContext;
	
	public SnakerEngine getObject() throws Exception {
		return new SpringConfiguration(applicationContext)
		.buildSnakerEngine();
	}

	public Class<SnakerEngine> getObjectType() {
		return SnakerEngine.class;
	}
	
	public boolean isSingleton() {
		return true;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}
