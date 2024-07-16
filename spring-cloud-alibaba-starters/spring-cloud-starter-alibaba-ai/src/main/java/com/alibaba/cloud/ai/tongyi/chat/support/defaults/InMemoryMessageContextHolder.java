/*
 * Copyright 2023-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.cloud.ai.tongyi.chat.support.defaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.cloud.ai.tongyi.chat.support.MessageContextHolder;
import com.alibaba.dashscope.common.Message;


/**
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 */

public class InMemoryMessageContextHolder implements MessageContextHolder {

	private final Map<String, List<Message>> sessionMessages = new HashMap<>();

	@Override
	public synchronized void addMessage(String sessionId, Message message) {

		sessionMessages.computeIfAbsent(sessionId, k -> new ArrayList<>()).add(message);
	}

	@Override
	public synchronized List<Message> getMessages(String sessionId) {

		return new ArrayList<>(sessionMessages.getOrDefault(sessionId, new ArrayList<>()));
	}

	@Override
	public synchronized void removeMessage(String sessionId) {

		sessionMessages.remove(sessionId);
	}

}
