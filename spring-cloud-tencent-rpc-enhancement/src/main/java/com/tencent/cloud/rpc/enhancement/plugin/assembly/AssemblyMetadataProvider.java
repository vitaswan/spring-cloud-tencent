/*
 * Tencent is pleased to support the open source community by making Spring Cloud Tencent available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.tencent.cloud.rpc.enhancement.plugin.assembly;

import com.tencent.polaris.api.pojo.ServiceKey;
import com.tencent.polaris.api.rpc.MetadataProvider;

import org.springframework.cloud.client.ServiceInstance;

/**
 * AssemblyMetadataProvider.
 *
 * @author sean yu
 */
public class AssemblyMetadataProvider implements MetadataProvider {

	private final ServiceInstance serviceInstance;

	private final String namespace;

	public AssemblyMetadataProvider(ServiceInstance localServiceInstance, String namespace) {
		this.serviceInstance = localServiceInstance;
		this.namespace = namespace;
	}

	@Override
	public String getMetadata(String key) {
		return serviceInstance.getMetadata().get(key);
	}

	@Override
	public ServiceKey getLocalService() {
		return new ServiceKey(namespace, serviceInstance.getServiceId());
	}

	@Override
	public String getLocalIp() {
		return serviceInstance.getHost();
	}

}