(ns mattermost-clj.api.users
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn users-autocomplete-get-with-http-info
  "Autocomplete users
  Get a list of users for the purpose of autocompleting based on the provided search term. Specify a combination of `team_id` and `channel_id` to filter results further.
##### Permissions
Requires an active session and `view_team` and `read_channel` on any teams or channels used to filter the results further."
  ([name ] (users-autocomplete-get-with-http-info name nil))
  ([name {:keys [team-id channel-id limit ]}]
   (check-required-params name)
   (call-api "/users/autocomplete" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"team_id" team-id "channel_id" channel-id "name" name "limit" limit }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-autocomplete-get
  "Autocomplete users
  Get a list of users for the purpose of autocompleting based on the provided search term. Specify a combination of `team_id` and `channel_id` to filter results further.
##### Permissions
Requires an active session and `view_team` and `read_channel` on any teams or channels used to filter the results further."
  ([name ] (users-autocomplete-get name nil))
  ([name optional-params]
   (:data (users-autocomplete-get-with-http-info name optional-params))))

(defn users-email-email-get-with-http-info
  "Get a user by email
  Get a user object by providing a user email. Sensitive information will be sanitized out.
##### Permissions
Requires an active session and for the current session to be able to view another user's email based on the server's privacy settings."
  [email ]
  (check-required-params email)
  (call-api "/users/email/{email}" :get
            {:path-params   {"email" email }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-email-email-get
  "Get a user by email
  Get a user object by providing a user email. Sensitive information will be sanitized out.
##### Permissions
Requires an active session and for the current session to be able to view another user's email based on the server's privacy settings."
  [email ]
  (:data (users-email-email-get-with-http-info email)))

(defn users-email-verify-post-with-http-info
  "Verify user email
  Verify the email used by a user to sign-up their account with.
##### Permissions
No permissions required."
  ([] (users-email-verify-post-with-http-info nil))
  ([{:keys [inline-object-13 ]}]
   (call-api "/users/email/verify" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-13
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-email-verify-post
  "Verify user email
  Verify the email used by a user to sign-up their account with.
##### Permissions
No permissions required."
  ([] (users-email-verify-post nil))
  ([optional-params]
   (:data (users-email-verify-post-with-http-info optional-params))))

(defn users-email-verify-send-post-with-http-info
  "Send verification email
  Send an email with a verification link to a user that has an email matching the one in the request body. This endpoint will return success even if the email does not match any users on the system.
##### Permissions
No permissions required."
  ([] (users-email-verify-send-post-with-http-info nil))
  ([{:keys [inline-object-14 ]}]
   (call-api "/users/email/verify/send" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-14
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-email-verify-send-post
  "Send verification email
  Send an email with a verification link to a user that has an email matching the one in the request body. This endpoint will return success even if the email does not match any users on the system.
##### Permissions
No permissions required."
  ([] (users-email-verify-send-post nil))
  ([optional-params]
   (:data (users-email-verify-send-post-with-http-info optional-params))))

(defn users-get-with-http-info
  "Get users
  Get a page of a list of users. Based on query string parameters, select users from a team, channel, or select users not in a specific channel.

Since server version 4.0, some basic sorting is available using the `sort` query parameter. Sorting is currently only supported when selecting users on a team.
##### Permissions
Requires an active session and (if specified) membership to the channel or team being selected from."
  ([] (users-get-with-http-info nil))
  ([{:keys [page per-page in-team not-in-team in-channel not-in-channel group-constrained without-team sort ]}]
   (call-api "/users" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "in_team" in-team "not_in_team" not-in-team "in_channel" in-channel "not_in_channel" not-in-channel "group_constrained" group-constrained "without_team" without-team "sort" sort }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-get
  "Get users
  Get a page of a list of users. Based on query string parameters, select users from a team, channel, or select users not in a specific channel.

Since server version 4.0, some basic sorting is available using the `sort` query parameter. Sorting is currently only supported when selecting users on a team.
##### Permissions
Requires an active session and (if specified) membership to the channel or team being selected from."
  ([] (users-get nil))
  ([optional-params]
   (:data (users-get-with-http-info optional-params))))

(defn users-group-channels-post-with-http-info
  "Get users by group channels ids
  Get an object containing a key per group channel id in the
query and its value as a list of users members of that group
channel.

The user must be a member of the group ids in the query, or
they will be omitted from the response.
##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 5.14"
  [string ]
  (check-required-params string)
  (call-api "/users/group_channels" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-group-channels-post
  "Get users by group channels ids
  Get an object containing a key per group channel id in the
query and its value as a list of users members of that group
channel.

The user must be a member of the group ids in the query, or
they will be omitted from the response.
##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 5.14"
  [string ]
  (:data (users-group-channels-post-with-http-info string)))

(defn users-ids-post-with-http-info
  "Get users by ids
  Get a list of users based on a provided list of user ids.
##### Permissions
Requires an active session but no other permissions."
  ([string ] (users-ids-post-with-http-info string nil))
  ([string {:keys [since ]}]
   (check-required-params string)
   (call-api "/users/ids" :post
             {:path-params   {}
              :header-params {}
              :query-params  {"since" since }
              :form-params   {}
              :body-param    string
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-ids-post
  "Get users by ids
  Get a list of users based on a provided list of user ids.
##### Permissions
Requires an active session but no other permissions."
  ([string ] (users-ids-post string nil))
  ([string optional-params]
   (:data (users-ids-post-with-http-info string optional-params))))

(defn users-login-switch-post-with-http-info
  "Switch login method
  Switch a user's login method from using email to OAuth2/SAML/LDAP or back to email. When switching to OAuth2/SAML, account switching is not complete until the user follows the returned link and completes any steps on the OAuth2/SAML service provider.

To switch from email to OAuth2/SAML, specify `current_service`, `new_service`, `email` and `password`.

To switch from OAuth2/SAML to email, specify `current_service`, `new_service`, `email` and `new_password`.

To switch from email to LDAP/AD, specify `current_service`, `new_service`, `email`, `password`, `ldap_ip` and `new_password` (this is the user's LDAP password).

To switch from LDAP/AD to email, specify `current_service`, `new_service`, `ldap_ip`, `password` (this is the user's LDAP password), `email`  and `new_password`.

Additionally, specify `mfa_code` when trying to switch an account on LDAP/AD or email that has MFA activated.

##### Permissions
No current authentication required except when switching from OAuth2/SAML to email."
  ([] (users-login-switch-post-with-http-info nil))
  ([{:keys [inline-object-15 ]}]
   (call-api "/users/login/switch" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-15
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-login-switch-post
  "Switch login method
  Switch a user's login method from using email to OAuth2/SAML/LDAP or back to email. When switching to OAuth2/SAML, account switching is not complete until the user follows the returned link and completes any steps on the OAuth2/SAML service provider.

To switch from email to OAuth2/SAML, specify `current_service`, `new_service`, `email` and `password`.

To switch from OAuth2/SAML to email, specify `current_service`, `new_service`, `email` and `new_password`.

To switch from email to LDAP/AD, specify `current_service`, `new_service`, `email`, `password`, `ldap_ip` and `new_password` (this is the user's LDAP password).

To switch from LDAP/AD to email, specify `current_service`, `new_service`, `ldap_ip`, `password` (this is the user's LDAP password), `email`  and `new_password`.

Additionally, specify `mfa_code` when trying to switch an account on LDAP/AD or email that has MFA activated.

##### Permissions
No current authentication required except when switching from OAuth2/SAML to email."
  ([] (users-login-switch-post nil))
  ([optional-params]
   (:data (users-login-switch-post-with-http-info optional-params))))

(defn users-mfa-post-with-http-info
  "Check MFA
  Check if a user has multi-factor authentication active on their account by providing a login id. Used to check whether an MFA code needs to be provided when logging in.
##### Permissions
No permission required."
  ([] (users-mfa-post-with-http-info nil))
  ([{:keys [inline-object-8 ]}]
   (call-api "/users/mfa" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-8
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-mfa-post
  "Check MFA
  Check if a user has multi-factor authentication active on their account by providing a login id. Used to check whether an MFA code needs to be provided when logging in.
##### Permissions
No permission required."
  ([] (users-mfa-post nil))
  ([optional-params]
   (:data (users-mfa-post-with-http-info optional-params))))

(defn users-password-reset-post-with-http-info
  "Reset password
  Update the password for a user using a one-use, timed recovery code tied to the user's account. Only works for non-SSO users.
##### Permissions
No permissions required."
  ([] (users-password-reset-post-with-http-info nil))
  ([{:keys [inline-object-6 ]}]
   (call-api "/users/password/reset" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-6
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-password-reset-post
  "Reset password
  Update the password for a user using a one-use, timed recovery code tied to the user's account. Only works for non-SSO users.
##### Permissions
No permissions required."
  ([] (users-password-reset-post nil))
  ([optional-params]
   (:data (users-password-reset-post-with-http-info optional-params))))

(defn users-password-reset-send-post-with-http-info
  "Send password reset email
  Send an email containing a link for resetting the user's password. The link will contain a one-use, timed recovery code tied to the user's account. Only works for non-SSO users.
##### Permissions
No permissions required."
  ([] (users-password-reset-send-post-with-http-info nil))
  ([{:keys [inline-object-10 ]}]
   (call-api "/users/password/reset/send" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-10
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-password-reset-send-post
  "Send password reset email
  Send an email containing a link for resetting the user's password. The link will contain a one-use, timed recovery code tied to the user's account. Only works for non-SSO users.
##### Permissions
No permissions required."
  ([] (users-password-reset-send-post nil))
  ([optional-params]
   (:data (users-password-reset-send-post-with-http-info optional-params))))

(defn users-post-with-http-info
  "Create a user
  Create a new user on the system. Password is required for email login. For other authentication types such as LDAP or SAML, auth_data and auth_service fields are required.
##### Permissions
No permission required but user creation can be controlled by server configuration."
  ([] (users-post-with-http-info nil))
  ([{:keys [t iid inline-object ]}]
   (call-api "/users" :post
             {:path-params   {}
              :header-params {}
              :query-params  {"t" t "iid" iid }
              :form-params   {}
              :body-param    inline-object
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-post
  "Create a user
  Create a new user on the system. Password is required for email login. For other authentication types such as LDAP or SAML, auth_data and auth_service fields are required.
##### Permissions
No permission required but user creation can be controlled by server configuration."
  ([] (users-post nil))
  ([optional-params]
   (:data (users-post-with-http-info optional-params))))

(defn users-search-post-with-http-info
  "Search users
  Get a list of users based on search criteria provided in the request body. Searches are typically done against username, full name, nickname and email unless otherwise configured by the server.
##### Permissions
Requires an active session and `read_channel` and/or `view_team` permissions for any channels or teams specified in the request body."
  ([] (users-search-post-with-http-info nil))
  ([{:keys [inline-object-1 ]}]
   (call-api "/users/search" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-1
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-search-post
  "Search users
  Get a list of users based on search criteria provided in the request body. Searches are typically done against username, full name, nickname and email unless otherwise configured by the server.
##### Permissions
Requires an active session and `read_channel` and/or `view_team` permissions for any channels or teams specified in the request body."
  ([] (users-search-post nil))
  ([optional-params]
   (:data (users-search-post-with-http-info optional-params))))

(defn users-sessions-device-put-with-http-info
  "Attach mobile device
  Attach a mobile device id to the currently logged in session. This will enable push notifications for a user, if configured by the server.
##### Permissions
Must be authenticated."
  ([] (users-sessions-device-put-with-http-info nil))
  ([{:keys [inline-object-12 ]}]
   (call-api "/users/sessions/device" :put
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-12
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-sessions-device-put
  "Attach mobile device
  Attach a mobile device id to the currently logged in session. This will enable push notifications for a user, if configured by the server.
##### Permissions
Must be authenticated."
  ([] (users-sessions-device-put nil))
  ([optional-params]
   (:data (users-sessions-device-put-with-http-info optional-params))))

(defn users-sessions-revoke-all-post-with-http-info
  "Revoke all sessions from all users.
  For any session currently on the server (including admin) it will be revoked.
Clients will be notified to log out users.

__Minimum server version__: 5.14

##### Permissions

Must have `manage_system` permission."
  []
  (call-api "/users/sessions/revoke/all" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-sessions-revoke-all-post
  "Revoke all sessions from all users.
  For any session currently on the server (including admin) it will be revoked.
Clients will be notified to log out users.

__Minimum server version__: 5.14

##### Permissions

Must have `manage_system` permission."
  []
  (:data (users-sessions-revoke-all-post-with-http-info)))

(defn users-stats-get-with-http-info
  "Get total count of users in the system
  Get a total count of users in the system.
##### Permissions
Must be authenticated."
  []
  (call-api "/users/stats" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-stats-get
  "Get total count of users in the system
  Get a total count of users in the system.
##### Permissions
Must be authenticated."
  []
  (:data (users-stats-get-with-http-info)))

(defn users-tokens-disable-post-with-http-info
  "Disable personal access token
  Disable a personal access token and delete any sessions using the token. The token can be re-enabled using `/users/tokens/enable`.

__Minimum server version__: 4.4

##### Permissions
Must have `revoke_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([] (users-tokens-disable-post-with-http-info nil))
  ([{:keys [inline-object-18 ]}]
   (call-api "/users/tokens/disable" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-18
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-tokens-disable-post
  "Disable personal access token
  Disable a personal access token and delete any sessions using the token. The token can be re-enabled using `/users/tokens/enable`.

__Minimum server version__: 4.4

##### Permissions
Must have `revoke_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([] (users-tokens-disable-post nil))
  ([optional-params]
   (:data (users-tokens-disable-post-with-http-info optional-params))))

(defn users-tokens-enable-post-with-http-info
  "Enable personal access token
  Re-enable a personal access token that has been disabled.

__Minimum server version__: 4.4

##### Permissions
Must have `create_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([] (users-tokens-enable-post-with-http-info nil))
  ([{:keys [inline-object-19 ]}]
   (call-api "/users/tokens/enable" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-19
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-tokens-enable-post
  "Enable personal access token
  Re-enable a personal access token that has been disabled.

__Minimum server version__: 4.4

##### Permissions
Must have `create_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([] (users-tokens-enable-post nil))
  ([optional-params]
   (:data (users-tokens-enable-post-with-http-info optional-params))))

(defn users-tokens-get-with-http-info
  "Get user access tokens
  Get a page of user access tokens for users on the system. Does not include the actual authentication tokens. Use query parameters for paging.

__Minimum server version__: 4.7

##### Permissions
Must have `manage_system` permission."
  ([] (users-tokens-get-with-http-info nil))
  ([{:keys [page per-page ]}]
   (call-api "/users/tokens" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-tokens-get
  "Get user access tokens
  Get a page of user access tokens for users on the system. Does not include the actual authentication tokens. Use query parameters for paging.

__Minimum server version__: 4.7

##### Permissions
Must have `manage_system` permission."
  ([] (users-tokens-get nil))
  ([optional-params]
   (:data (users-tokens-get-with-http-info optional-params))))

(defn users-tokens-revoke-post-with-http-info
  "Revoke a user access token
  Revoke a user access token and delete any sessions using the token.

__Minimum server version__: 4.1

##### Permissions
Must have `revoke_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([] (users-tokens-revoke-post-with-http-info nil))
  ([{:keys [inline-object-17 ]}]
   (call-api "/users/tokens/revoke" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-17
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-tokens-revoke-post
  "Revoke a user access token
  Revoke a user access token and delete any sessions using the token.

__Minimum server version__: 4.1

##### Permissions
Must have `revoke_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([] (users-tokens-revoke-post nil))
  ([optional-params]
   (:data (users-tokens-revoke-post-with-http-info optional-params))))

(defn users-tokens-search-post-with-http-info
  "Search tokens
  Get a list of tokens based on search criteria provided in the request body. Searches are done against the token id, user id and username.

__Minimum server version__: 4.7

##### Permissions
Must have `manage_system` permission."
  ([] (users-tokens-search-post-with-http-info nil))
  ([{:keys [inline-object-20 ]}]
   (call-api "/users/tokens/search" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-20
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-tokens-search-post
  "Search tokens
  Get a list of tokens based on search criteria provided in the request body. Searches are done against the token id, user id and username.

__Minimum server version__: 4.7

##### Permissions
Must have `manage_system` permission."
  ([] (users-tokens-search-post nil))
  ([optional-params]
   (:data (users-tokens-search-post-with-http-info optional-params))))

(defn users-tokens-token-id-get-with-http-info
  "Get a user access token
  Get a user access token. Does not include the actual authentication token.

__Minimum server version__: 4.1

##### Permissions
Must have `read_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  [token-id ]
  (check-required-params token-id)
  (call-api "/users/tokens/{token_id}" :get
            {:path-params   {"token_id" token-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-tokens-token-id-get
  "Get a user access token
  Get a user access token. Does not include the actual authentication token.

__Minimum server version__: 4.1

##### Permissions
Must have `read_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  [token-id ]
  (:data (users-tokens-token-id-get-with-http-info token-id)))

(defn users-user-id-active-put-with-http-info
  "Update user active status
  Update user active or inactive status.

__Since server version 4.6, users using a SSO provider to login can be activated or deactivated with this endpoint. However, if their activation status in Mattermost does not reflect their status in the SSO provider, the next synchronization or login by that user will reset the activation status to that of their account in the SSO provider. Server versions 4.5 and before do not allow activation or deactivation of SSO users from this endpoint.__
##### Permissions
User can deactivate themselves.
User with `manage_system` permission can activate or deactivate a user."
  ([user-id ] (users-user-id-active-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-5 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/active" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-5
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-active-put
  "Update user active status
  Update user active or inactive status.

__Since server version 4.6, users using a SSO provider to login can be activated or deactivated with this endpoint. However, if their activation status in Mattermost does not reflect their status in the SSO provider, the next synchronization or login by that user will reset the activation status to that of their account in the SSO provider. Server versions 4.5 and before do not allow activation or deactivation of SSO users from this endpoint.__
##### Permissions
User can deactivate themselves.
User with `manage_system` permission can activate or deactivate a user."
  ([user-id ] (users-user-id-active-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-active-put-with-http-info user-id optional-params))))

(defn users-user-id-audits-get-with-http-info
  "Get user's audits
  Get a list of audit by providing the user GUID.
##### Permissions
Must be logged in as the user or have the `edit_other_users` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/audits" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-audits-get
  "Get user's audits
  Get a list of audit by providing the user GUID.
##### Permissions
Must be logged in as the user or have the `edit_other_users` permission."
  [user-id ]
  (:data (users-user-id-audits-get-with-http-info user-id)))

(defn users-user-id-auth-put-with-http-info
  "Update a user's authentication method
  Updates a user's authentication method. This can be used to change them to/from LDAP authentication for example.

__Minimum server version__: 4.6
##### Permissions
Must have the `edit_other_users` permission."
  [user-id user-auth-data ]
  (check-required-params user-id user-auth-data)
  (call-api "/users/{user_id}/auth" :put
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    user-auth-data
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-auth-put
  "Update a user's authentication method
  Updates a user's authentication method. This can be used to change them to/from LDAP authentication for example.

__Minimum server version__: 4.6
##### Permissions
Must have the `edit_other_users` permission."
  [user-id user-auth-data ]
  (:data (users-user-id-auth-put-with-http-info user-id user-auth-data)))

(defn users-user-id-delete-with-http-info
  "Deactivate a user account.
  Deactivates the user and revokes all its sessions by archiving its user object.
##### Permissions
Must be logged in as the user being deactivated or have the `edit_other_users` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}" :delete
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-delete
  "Deactivate a user account.
  Deactivates the user and revokes all its sessions by archiving its user object.
##### Permissions
Must be logged in as the user being deactivated or have the `edit_other_users` permission."
  [user-id ]
  (:data (users-user-id-delete-with-http-info user-id)))

(defn users-user-id-demote-post-with-http-info
  "Demote a user to a guest
  Convert a regular user into a guest. This will convert the user into a
guest for the whole system while retaining their existing team and
channel memberships.

__Minimum server version__: 5.16

##### Permissions
Must be logged in as the user or have the `demote_to_guest` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/demote" :post
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-demote-post
  "Demote a user to a guest
  Convert a regular user into a guest. This will convert the user into a
guest for the whole system while retaining their existing team and
channel memberships.

__Minimum server version__: 5.16

##### Permissions
Must be logged in as the user or have the `demote_to_guest` permission."
  [user-id ]
  (:data (users-user-id-demote-post-with-http-info user-id)))

(defn users-user-id-get-with-http-info
  "Get a user
  Get a user a object. Sensitive information will be sanitized out.
##### Permissions
Requires an active session but no other permissions."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-get
  "Get a user
  Get a user a object. Sensitive information will be sanitized out.
##### Permissions
Requires an active session but no other permissions."
  [user-id ]
  (:data (users-user-id-get-with-http-info user-id)))

(defn users-user-id-image-default-get-with-http-info
  "Return user's default (generated) profile image
  Returns the default (generated) user profile image based on user_id string parameter.
##### Permissions
Must be logged in.
__Minimum server version__: 5.5"
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/image/default" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-image-default-get
  "Return user's default (generated) profile image
  Returns the default (generated) user profile image based on user_id string parameter.
##### Permissions
Must be logged in.
__Minimum server version__: 5.5"
  [user-id ]
  (:data (users-user-id-image-default-get-with-http-info user-id)))

(defn users-user-id-image-delete-with-http-info
  "Delete user's profile image
  Delete user's profile image and reset to default image based on user_id string parameter.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission.
__Minimum server version__: 5.5"
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/image" :delete
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-image-delete
  "Delete user's profile image
  Delete user's profile image and reset to default image based on user_id string parameter.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission.
__Minimum server version__: 5.5"
  [user-id ]
  (:data (users-user-id-image-delete-with-http-info user-id)))

(defn users-user-id-image-get-with-http-info
  "Get user's profile image
  Get a user's profile image based on user_id string parameter.
##### Permissions
Must be logged in."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/image" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-image-get
  "Get user's profile image
  Get a user's profile image based on user_id string parameter.
##### Permissions
Must be logged in."
  [user-id ]
  (:data (users-user-id-image-get-with-http-info user-id)))

(defn users-user-id-image-post-with-http-info
  "Set user's profile image
  Set a user's profile image based on user_id string parameter.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id ^File image ]
  (check-required-params user-id image)
  (call-api "/users/{user_id}/image" :post
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {"image" image }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-image-post
  "Set user's profile image
  Set a user's profile image based on user_id string parameter.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id ^File image ]
  (:data (users-user-id-image-post-with-http-info user-id image)))

(defn users-user-id-mfa-generate-post-with-http-info
  "Generate MFA secret
  Generates an multi-factor authentication secret for a user and returns it as a string and as base64 encoded QR code image.
##### Permissions
Must be logged in as the user or have the `edit_other_users` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/mfa/generate" :post
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-mfa-generate-post
  "Generate MFA secret
  Generates an multi-factor authentication secret for a user and returns it as a string and as base64 encoded QR code image.
##### Permissions
Must be logged in as the user or have the `edit_other_users` permission."
  [user-id ]
  (:data (users-user-id-mfa-generate-post-with-http-info user-id)))

(defn users-user-id-mfa-put-with-http-info
  "Update a user's MFA
  Activates multi-factor authentication for the user if `activate` is true and a valid `code` is provided. If activate is false, then `code` is not required and multi-factor authentication is disabled for the user.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-mfa-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-7 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/mfa" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-7
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-mfa-put
  "Update a user's MFA
  Activates multi-factor authentication for the user if `activate` is true and a valid `code` is provided. If activate is false, then `code` is not required and multi-factor authentication is disabled for the user.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-mfa-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-mfa-put-with-http-info user-id optional-params))))

(defn users-user-id-password-put-with-http-info
  "Update a user's password
  Update a user's password. New password must meet password policy set by server configuration. Current password is required if you're updating your own password.
##### Permissions
Must be logged in as the user the password is being changed for or have `manage_system` permission."
  ([user-id ] (users-user-id-password-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-9 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/password" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-9
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-password-put
  "Update a user's password
  Update a user's password. New password must meet password policy set by server configuration. Current password is required if you're updating your own password.
##### Permissions
Must be logged in as the user the password is being changed for or have `manage_system` permission."
  ([user-id ] (users-user-id-password-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-password-put-with-http-info user-id optional-params))))

(defn users-user-id-patch-put-with-http-info
  "Patch a user
  Partially update a user by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-patch-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-3 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/patch" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-3
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-patch-put
  "Patch a user
  Partially update a user by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-patch-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-patch-put-with-http-info user-id optional-params))))

(defn users-user-id-promote-post-with-http-info
  "Promote a guest to user
  Convert a guest into a regular user. This will convert the guest into a
user for the whole system while retaining any team and channel
memberships and automatically joining them to the default channels.

__Minimum server version__: 5.16

##### Permissions
Must be logged in as the user or have the `promote_guest` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/promote" :post
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-promote-post
  "Promote a guest to user
  Convert a guest into a regular user. This will convert the guest into a
user for the whole system while retaining any team and channel
memberships and automatically joining them to the default channels.

__Minimum server version__: 5.16

##### Permissions
Must be logged in as the user or have the `promote_guest` permission."
  [user-id ]
  (:data (users-user-id-promote-post-with-http-info user-id)))

(defn users-user-id-put-with-http-info
  "Update a user
  Update a user by providing the user object. The fields that can be updated are defined in the request body, all other provided fields will be ignored. Any fields not included in the request body will be set to null or reverted to default values.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-2 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-2
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-put
  "Update a user
  Update a user by providing the user object. The fields that can be updated are defined in the request body, all other provided fields will be ignored. Any fields not included in the request body will be set to null or reverted to default values.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-put-with-http-info user-id optional-params))))

(defn users-user-id-roles-put-with-http-info
  "Update a user's roles
  Update a user's system-level roles. Valid user roles are \"system_user\", \"system_admin\" or both of them. Overwrites any previously assigned system-level roles.
##### Permissions
Must have the `manage_roles` permission."
  ([user-id ] (users-user-id-roles-put-with-http-info user-id nil))
  ([user-id {:keys [inline-object-4 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/roles" :put
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-4
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-roles-put
  "Update a user's roles
  Update a user's system-level roles. Valid user roles are \"system_user\", \"system_admin\" or both of them. Overwrites any previously assigned system-level roles.
##### Permissions
Must have the `manage_roles` permission."
  ([user-id ] (users-user-id-roles-put user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-roles-put-with-http-info user-id optional-params))))

(defn users-user-id-sessions-get-with-http-info
  "Get user's sessions
  Get a list of sessions by providing the user GUID. Sensitive information will be sanitized out.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/sessions" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-sessions-get
  "Get user's sessions
  Get a list of sessions by providing the user GUID. Sensitive information will be sanitized out.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  [user-id ]
  (:data (users-user-id-sessions-get-with-http-info user-id)))

(defn users-user-id-sessions-revoke-all-post-with-http-info
  "Revoke all active sessions for a user
  Revokes all user sessions from the provided user id and session id strings.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission.
__Minimum server version__: 4.4"
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/sessions/revoke/all" :post
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-sessions-revoke-all-post
  "Revoke all active sessions for a user
  Revokes all user sessions from the provided user id and session id strings.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission.
__Minimum server version__: 4.4"
  [user-id ]
  (:data (users-user-id-sessions-revoke-all-post-with-http-info user-id)))

(defn users-user-id-sessions-revoke-post-with-http-info
  "Revoke a user session
  Revokes a user session from the provided user id and session id strings.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-sessions-revoke-post-with-http-info user-id nil))
  ([user-id {:keys [inline-object-11 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/sessions/revoke" :post
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-11
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-sessions-revoke-post
  "Revoke a user session
  Revokes a user session from the provided user id and session id strings.
##### Permissions
Must be logged in as the user being updated or have the `edit_other_users` permission."
  ([user-id ] (users-user-id-sessions-revoke-post user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-sessions-revoke-post-with-http-info user-id optional-params))))

(defn users-user-id-terms-of-service-get-with-http-info
  "Fetches user's latest terms of service action if the latest action was for acceptance.
  Will be deprecated in v6.0
Fetches user's latest terms of service action if the latest action was for acceptance.

__Minimum server version__: 5.6
##### Permissions
Must be logged in as the user being acted on."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/terms_of_service" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-terms-of-service-get
  "Fetches user's latest terms of service action if the latest action was for acceptance.
  Will be deprecated in v6.0
Fetches user's latest terms of service action if the latest action was for acceptance.

__Minimum server version__: 5.6
##### Permissions
Must be logged in as the user being acted on."
  [user-id ]
  (:data (users-user-id-terms-of-service-get-with-http-info user-id)))

(defn users-user-id-terms-of-service-post-with-http-info
  "Records user action when they accept or decline custom terms of service
  Records user action when they accept or decline custom terms of service. Records the action in audit table.
Updates user's last accepted terms of service ID if they accepted it.

__Minimum server version__: 5.4
##### Permissions
Must be logged in as the user being acted on."
  ([user-id ] (users-user-id-terms-of-service-post-with-http-info user-id nil))
  ([user-id {:keys [inline-object-21 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/terms_of_service" :post
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-21
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-terms-of-service-post
  "Records user action when they accept or decline custom terms of service
  Records user action when they accept or decline custom terms of service. Records the action in audit table.
Updates user's last accepted terms of service ID if they accepted it.

__Minimum server version__: 5.4
##### Permissions
Must be logged in as the user being acted on."
  ([user-id ] (users-user-id-terms-of-service-post user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-terms-of-service-post-with-http-info user-id optional-params))))

(defn users-user-id-tokens-get-with-http-info
  "Get user access tokens
  Get a list of user access tokens for a user. Does not include the actual authentication tokens. Use query parameters for paging.

__Minimum server version__: 4.1

##### Permissions
Must have `read_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([user-id ] (users-user-id-tokens-get-with-http-info user-id nil))
  ([user-id {:keys [page per-page ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/tokens" :get
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-tokens-get
  "Get user access tokens
  Get a list of user access tokens for a user. Does not include the actual authentication tokens. Use query parameters for paging.

__Minimum server version__: 4.1

##### Permissions
Must have `read_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([user-id ] (users-user-id-tokens-get user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-tokens-get-with-http-info user-id optional-params))))

(defn users-user-id-tokens-post-with-http-info
  "Create a user access token
  Generate a user access token that can be used to authenticate with the Mattermost REST API.

__Minimum server version__: 4.1

##### Permissions
Must have `create_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([user-id ] (users-user-id-tokens-post-with-http-info user-id nil))
  ([user-id {:keys [inline-object-16 ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/tokens" :post
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-16
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-tokens-post
  "Create a user access token
  Generate a user access token that can be used to authenticate with the Mattermost REST API.

__Minimum server version__: 4.1

##### Permissions
Must have `create_user_access_token` permission. For non-self requests, must also have the `edit_other_users` permission."
  ([user-id ] (users-user-id-tokens-post user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-tokens-post-with-http-info user-id optional-params))))

(defn users-username-username-get-with-http-info
  "Get a user by username
  Get a user object by providing a username. Sensitive information will be sanitized out.
##### Permissions
Requires an active session but no other permissions."
  [username ]
  (check-required-params username)
  (call-api "/users/username/{username}" :get
            {:path-params   {"username" username }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-username-username-get
  "Get a user by username
  Get a user object by providing a username. Sensitive information will be sanitized out.
##### Permissions
Requires an active session but no other permissions."
  [username ]
  (:data (users-username-username-get-with-http-info username)))

(defn users-usernames-post-with-http-info
  "Get users by usernames
  Get a list of users based on a provided list of usernames.
##### Permissions
Requires an active session but no other permissions."
  [string ]
  (check-required-params string)
  (call-api "/users/usernames" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-usernames-post
  "Get users by usernames
  Get a list of users based on a provided list of usernames.
##### Permissions
Requires an active session but no other permissions."
  [string ]
  (:data (users-usernames-post-with-http-info string)))

