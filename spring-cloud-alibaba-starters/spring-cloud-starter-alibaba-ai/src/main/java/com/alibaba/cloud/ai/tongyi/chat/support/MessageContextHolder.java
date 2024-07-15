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

package com.alibaba.cloud.ai.tongyi.chat.support;

import java.util.List;

import org.springframework.ai.chat.messages.Message;

/**
 * @author yuluo
 * @author <a href="mailto:yuluo08290126@gmail.com">yuluo</a>
 * Abstracts the storage of messages in a chat session. Use session id as the key to store messages.
 * You can customize the message context store by implementing this interface.
 * @see com.alibaba.cloud.ai.tongyi.chat.support.defaults.InMemoryMessageContextHolder
 * @since 2023.0.1.0
 */

public interface MessageContextHolder {

	void addMessage(String sessionId, Message message);

	void removeMessage(String sessionId);

	List<Message> getMessages(String sessionId);

}
