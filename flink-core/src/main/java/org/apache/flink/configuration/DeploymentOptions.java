/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.flink.configuration;

import org.apache.flink.annotation.PublicEvolving;

import static org.apache.flink.configuration.ConfigOptions.key;

/**
 * The {@link ConfigOption configuration options} relevant for all Executors.
 */
@PublicEvolving
//远程客户端的相关配置
public class DeploymentOptions {

	//指定部署目标部署在哪里
	public static final ConfigOption<String> TARGET =
			key("execution.target")
					.stringType()
					.noDefaultValue()
					.withDescription("The deployment target for the execution, e.g. \"local\" for local execution.");
	//指定管道信息是附加模式还是分离模式
	public static final ConfigOption<Boolean> ATTACHED =
			key("execution.attached")
					.booleanType()
					.defaultValue(false)
					.withDescription("Specifies if the pipeline is submitted in attached or detached mode.");
	//如果作业使用附加模式，可以使用Ctrl+c的进行终止
	public static final ConfigOption<Boolean> SHUTDOWN_IF_ATTACHED =
			key("execution.shutdown-on-attached-exit")
					.booleanType()
					.defaultValue(false)
					.withDescription("If the job is submitted in attached mode, perform a best-effort cluster shutdown " +
							"when the CLI is terminated abruptly, e.g., in response to a user interrupt, such as typing Ctrl + C.");
}
