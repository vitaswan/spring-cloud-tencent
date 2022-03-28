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

package com.tencent.cloud.common.metadata;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

/**
 * Test for {@link MetadataAutoConfiguration}
 *
 * @author Haotian Zhang
 */
public class MetadataAutoConfigurationTest {

	private final ApplicationContextRunner applicationContextRunner = new ApplicationContextRunner();

	@Test
	public void test1() {
		this.applicationContextRunner
				.withConfiguration(AutoConfigurations.of(MetadataAutoConfiguration.class))
				.run(context -> {
					Assertions.assertThat(context)
							.hasSingleBean(MetadataLocalProperties.class);
				});
	}

}