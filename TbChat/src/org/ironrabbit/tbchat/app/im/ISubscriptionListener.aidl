/*
 * Copyright (C) 2008 Esmertec AG.
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package org.ironrabbit.tbchat.app.im;

import org.ironrabbit.tbchat.app.im.engine.Contact;

oneway interface ISubscriptionListener {
    /**
     * Called when:
     *  <ul>
     *  <li> the request a contact has sent to client
     *  </ul>
     *
     * @see org.ironrabbit.tbchat.app.im.engine.SubscriptionRequestListener#onSubScriptionRequest(Contact from)
     */
    void onSubScriptionRequest(in Contact from);

    /**
     * Called when the request is approved by user.
     *
     * @see org.ironrabbit.tbchat.app.im.engine.SubscriptionRequestListener#onSubscriptionApproved(String contact)
     */
    void onSubscriptionApproved(String contact);

    /**
     * Called when a subscription request is declined.
     *
     * @see org.ironrabbit.tbchat.app.im.engine.ContactListListener#onSubscriptionDeclined(String contact)
     */
    void onSubscriptionDeclined(String contact);
}
