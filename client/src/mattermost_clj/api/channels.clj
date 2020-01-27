(ns mattermost-clj.api.channels
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn channels-channel-id-convert-post-with-http-info
  "Convert a channel from public to private
  Convert into private channel from the provided channel id string.

__Minimum server version__: 4.10

##### Permissions
`manage_team` permission for the team of the channel."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}/convert" :post
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-convert-post
  "Convert a channel from public to private
  Convert into private channel from the provided channel id string.

__Minimum server version__: 4.10

##### Permissions
`manage_team` permission for the team of the channel."
  [channel-id ]
  (:data (channels-channel-id-convert-post-with-http-info channel-id)))

(defn channels-channel-id-delete-with-http-info
  "Delete a channel
  Soft deletes a channel, by marking the channel as deleted in the database. Soft deleted channels will not be accessible in the user interface. Direct and group message channels cannot be deleted.
##### Permissions
`delete_public_channel` permission if the channel is public,
`delete_private_channel` permission if the channel is private,
or have `manage_system` permission."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}" :delete
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-delete
  "Delete a channel
  Soft deletes a channel, by marking the channel as deleted in the database. Soft deleted channels will not be accessible in the user interface. Direct and group message channels cannot be deleted.
##### Permissions
`delete_public_channel` permission if the channel is public,
`delete_private_channel` permission if the channel is private,
or have `manage_system` permission."
  [channel-id ]
  (:data (channels-channel-id-delete-with-http-info channel-id)))

(defn channels-channel-id-get-with-http-info
  "Get a channel
  Get channel from the provided channel id string.
##### Permissions
`read_channel` permission for the channel."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}" :get
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-get
  "Get a channel
  Get channel from the provided channel id string.
##### Permissions
`read_channel` permission for the channel."
  [channel-id ]
  (:data (channels-channel-id-get-with-http-info channel-id)))

(defn channels-channel-id-members-get-with-http-info
  "Get channel members
  Get a page of members for a channel.
##### Permissions
`read_channel` permission for the channel."
  ([channel-id ] (channels-channel-id-members-get-with-http-info channel-id nil))
  ([channel-id {:keys [page per-page ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}/members" :get
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-members-get
  "Get channel members
  Get a page of members for a channel.
##### Permissions
`read_channel` permission for the channel."
  ([channel-id ] (channels-channel-id-members-get channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-members-get-with-http-info channel-id optional-params))))

(defn channels-channel-id-members-ids-post-with-http-info
  "Get channel members by ids
  Get a list of channel members based on the provided user ids.
##### Permissions
Must have the `read_channel` permission."
  [channel-id string ]
  (check-required-params channel-id string)
  (call-api "/channels/{channel_id}/members/ids" :post
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-members-ids-post
  "Get channel members by ids
  Get a list of channel members based on the provided user ids.
##### Permissions
Must have the `read_channel` permission."
  [channel-id string ]
  (:data (channels-channel-id-members-ids-post-with-http-info channel-id string)))

(defn channels-channel-id-members-minus-group-members-get-with-http-info
  "Channel members minus group members.
  Get the set of users who are members of the channel minus the set of users who are members of the given groups.
Each user object contains an array of group objects representing the group memberships for that user.
Each user object contains the boolean fields `scheme_guest`, `scheme_user`, and `scheme_admin` representing the roles that user has for the given channel.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.14"
  ([channel-id group-ids ] (channels-channel-id-members-minus-group-members-get-with-http-info channel-id group-ids nil))
  ([channel-id group-ids {:keys [page per-page ]}]
   (check-required-params channel-id group-ids)
   (call-api "/channels/{channel_id}/members_minus_group_members" :get
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {"group_ids" group-ids "page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-members-minus-group-members-get
  "Channel members minus group members.
  Get the set of users who are members of the channel minus the set of users who are members of the given groups.
Each user object contains an array of group objects representing the group memberships for that user.
Each user object contains the boolean fields `scheme_guest`, `scheme_user`, and `scheme_admin` representing the roles that user has for the given channel.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.14"
  ([channel-id group-ids ] (channels-channel-id-members-minus-group-members-get channel-id group-ids nil))
  ([channel-id group-ids optional-params]
   (:data (channels-channel-id-members-minus-group-members-get-with-http-info channel-id group-ids optional-params))))

(defn channels-channel-id-members-post-with-http-info
  "Add user to channel
  Add a user to a channel by creating a channel member object."
  ([channel-id ] (channels-channel-id-members-post-with-http-info channel-id nil))
  ([channel-id {:keys [inline-object-37 ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}/members" :post
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-37
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-members-post
  "Add user to channel
  Add a user to a channel by creating a channel member object."
  ([channel-id ] (channels-channel-id-members-post channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-members-post-with-http-info channel-id optional-params))))

(defn channels-channel-id-members-user-id-delete-with-http-info
  "Remove user from channel
  Delete a channel member, effectively removing them from a channel.

In server version 5.3 and later, channel members can only be deleted from public or private channels.
##### Permissions
`manage_public_channel_members` permission if the channel is public.
`manage_private_channel_members` permission if the channel is private."
  [channel-id user-id ]
  (check-required-params channel-id user-id)
  (call-api "/channels/{channel_id}/members/{user_id}" :delete
            {:path-params   {"channel_id" channel-id "user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-members-user-id-delete
  "Remove user from channel
  Delete a channel member, effectively removing them from a channel.

In server version 5.3 and later, channel members can only be deleted from public or private channels.
##### Permissions
`manage_public_channel_members` permission if the channel is public.
`manage_private_channel_members` permission if the channel is private."
  [channel-id user-id ]
  (:data (channels-channel-id-members-user-id-delete-with-http-info channel-id user-id)))

(defn channels-channel-id-members-user-id-get-with-http-info
  "Get channel member
  Get a channel member.
##### Permissions
`read_channel` permission for the channel."
  [channel-id user-id ]
  (check-required-params channel-id user-id)
  (call-api "/channels/{channel_id}/members/{user_id}" :get
            {:path-params   {"channel_id" channel-id "user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-members-user-id-get
  "Get channel member
  Get a channel member.
##### Permissions
`read_channel` permission for the channel."
  [channel-id user-id ]
  (:data (channels-channel-id-members-user-id-get-with-http-info channel-id user-id)))

(defn channels-channel-id-members-user-id-notify-props-put-with-http-info
  "Update channel notifications
  Update a user's notification properties for a channel. Only the provided fields are updated.
##### Permissions
Must be logged in as the user or have `edit_other_users` permission."
  [channel-id user-id channel-notify-props ]
  (check-required-params channel-id user-id channel-notify-props)
  (call-api "/channels/{channel_id}/members/{user_id}/notify_props" :put
            {:path-params   {"channel_id" channel-id "user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    channel-notify-props
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-members-user-id-notify-props-put
  "Update channel notifications
  Update a user's notification properties for a channel. Only the provided fields are updated.
##### Permissions
Must be logged in as the user or have `edit_other_users` permission."
  [channel-id user-id channel-notify-props ]
  (:data (channels-channel-id-members-user-id-notify-props-put-with-http-info channel-id user-id channel-notify-props)))

(defn channels-channel-id-members-user-id-roles-put-with-http-info
  "Update channel roles
  Update a user's roles for a channel.
##### Permissions
Must have `manage_channel_roles` permission for the channel."
  ([channel-id user-id ] (channels-channel-id-members-user-id-roles-put-with-http-info channel-id user-id nil))
  ([channel-id user-id {:keys [inline-object-38 ]}]
   (check-required-params channel-id user-id)
   (call-api "/channels/{channel_id}/members/{user_id}/roles" :put
             {:path-params   {"channel_id" channel-id "user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-38
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-members-user-id-roles-put
  "Update channel roles
  Update a user's roles for a channel.
##### Permissions
Must have `manage_channel_roles` permission for the channel."
  ([channel-id user-id ] (channels-channel-id-members-user-id-roles-put channel-id user-id nil))
  ([channel-id user-id optional-params]
   (:data (channels-channel-id-members-user-id-roles-put-with-http-info channel-id user-id optional-params))))

(defn channels-channel-id-members-user-id-scheme-roles-put-with-http-info
  "Update the scheme-derived roles of a channel member.
  Update a channel member's scheme_admin/scheme_user properties. Typically this should either be `scheme_admin=false, scheme_user=true` for ordinary channel member, or `scheme_admin=true, scheme_user=true` for a channel admin.
__Minimum server version__: 5.0
##### Permissions
Must be authenticated and have the `manage_channel_roles` permission."
  ([channel-id user-id ] (channels-channel-id-members-user-id-scheme-roles-put-with-http-info channel-id user-id nil))
  ([channel-id user-id {:keys [inline-object-39 ]}]
   (check-required-params channel-id user-id)
   (call-api "/channels/{channel_id}/members/{user_id}/schemeRoles" :put
             {:path-params   {"channel_id" channel-id "user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-39
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-members-user-id-scheme-roles-put
  "Update the scheme-derived roles of a channel member.
  Update a channel member's scheme_admin/scheme_user properties. Typically this should either be `scheme_admin=false, scheme_user=true` for ordinary channel member, or `scheme_admin=true, scheme_user=true` for a channel admin.
__Minimum server version__: 5.0
##### Permissions
Must be authenticated and have the `manage_channel_roles` permission."
  ([channel-id user-id ] (channels-channel-id-members-user-id-scheme-roles-put channel-id user-id nil))
  ([channel-id user-id optional-params]
   (:data (channels-channel-id-members-user-id-scheme-roles-put-with-http-info channel-id user-id optional-params))))

(defn channels-channel-id-patch-put-with-http-info
  "Patch a channel
  Partially update a channel by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
If updating a public channel, `manage_public_channel_members` permission is required. If updating a private channel, `manage_private_channel_members` permission is required."
  ([channel-id ] (channels-channel-id-patch-put-with-http-info channel-id nil))
  ([channel-id {:keys [inline-object-35 ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}/patch" :put
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-35
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-patch-put
  "Patch a channel
  Partially update a channel by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
If updating a public channel, `manage_public_channel_members` permission is required. If updating a private channel, `manage_private_channel_members` permission is required."
  ([channel-id ] (channels-channel-id-patch-put channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-patch-put-with-http-info channel-id optional-params))))

(defn channels-channel-id-pinned-get-with-http-info
  "Get a channel's pinned posts
  Get a list of pinned posts for channel."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}/pinned" :get
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-pinned-get
  "Get a channel's pinned posts
  Get a list of pinned posts for channel."
  [channel-id ]
  (:data (channels-channel-id-pinned-get-with-http-info channel-id)))

(defn channels-channel-id-put-with-http-info
  "Update a channel
  Update a channel. The fields that can be updated are listed as parameters. Omitted fields will be treated as blanks.
##### Permissions
If updating a public channel, `manage_public_channel_members` permission is required. If updating a private channel, `manage_private_channel_members` permission is required."
  ([channel-id ] (channels-channel-id-put-with-http-info channel-id nil))
  ([channel-id {:keys [inline-object-34 ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}" :put
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-34
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-put
  "Update a channel
  Update a channel. The fields that can be updated are listed as parameters. Omitted fields will be treated as blanks.
##### Permissions
If updating a public channel, `manage_public_channel_members` permission is required. If updating a private channel, `manage_private_channel_members` permission is required."
  ([channel-id ] (channels-channel-id-put channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-put-with-http-info channel-id optional-params))))

(defn channels-channel-id-restore-post-with-http-info
  "Restore a channel
  Restore channel from the provided channel id string.

__Minimum server version__: 3.10

##### Permissions
`manage_team` permission for the team of the channel."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}/restore" :post
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-restore-post
  "Restore a channel
  Restore channel from the provided channel id string.

__Minimum server version__: 3.10

##### Permissions
`manage_team` permission for the team of the channel."
  [channel-id ]
  (:data (channels-channel-id-restore-post-with-http-info channel-id)))

(defn channels-channel-id-scheme-put-with-http-info
  "Set a channel's scheme
  Set a channel's scheme, more specifically sets the scheme_id value of a channel record.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.10"
  ([channel-id ] (channels-channel-id-scheme-put-with-http-info channel-id nil))
  ([channel-id {:keys [inline-object-41 ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}/scheme" :put
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-41
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-channel-id-scheme-put
  "Set a channel's scheme
  Set a channel's scheme, more specifically sets the scheme_id value of a channel record.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.10"
  ([channel-id ] (channels-channel-id-scheme-put channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-scheme-put-with-http-info channel-id optional-params))))

(defn channels-channel-id-stats-get-with-http-info
  "Get channel statistics
  Get statistics for a channel.
##### Permissions
Must have the `read_channel` permission."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}/stats" :get
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-stats-get
  "Get channel statistics
  Get statistics for a channel.
##### Permissions
Must have the `read_channel` permission."
  [channel-id ]
  (:data (channels-channel-id-stats-get-with-http-info channel-id)))

(defn channels-channel-id-timezones-get-with-http-info
  "Get timezones in a channel
  Get a list of timezones for the users who are in this channel.

__Minimum server version__: 5.6

##### Permissions
Must have the `read_channel` permission."
  [channel-id ]
  (check-required-params channel-id)
  (call-api "/channels/{channel_id}/timezones" :get
            {:path-params   {"channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-channel-id-timezones-get
  "Get timezones in a channel
  Get a list of timezones for the users who are in this channel.

__Minimum server version__: 5.6

##### Permissions
Must have the `read_channel` permission."
  [channel-id ]
  (:data (channels-channel-id-timezones-get-with-http-info channel-id)))

(defn channels-direct-post-with-http-info
  "Create a direct message channel
  Create a new direct message channel between two users.
##### Permissions
Must be one of the two users and have `create_direct_channel` permission. Having the `manage_system` permission voids the previous requirements."
  [string ]
  (check-required-params string)
  (call-api "/channels/direct" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-direct-post
  "Create a direct message channel
  Create a new direct message channel between two users.
##### Permissions
Must be one of the two users and have `create_direct_channel` permission. Having the `manage_system` permission voids the previous requirements."
  [string ]
  (:data (channels-direct-post-with-http-info string)))

(defn channels-group-post-with-http-info
  "Create a group message channel
  Create a new group message channel to group of users. If the logged in user's id is not included in the list, it will be appended to the end.
##### Permissions
Must have `create_group_channel` permission."
  [string ]
  (check-required-params string)
  (call-api "/channels/group" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn channels-group-post
  "Create a group message channel
  Create a new group message channel to group of users. If the logged in user's id is not included in the list, it will be appended to the end.
##### Permissions
Must have `create_group_channel` permission."
  [string ]
  (:data (channels-group-post-with-http-info string)))

(defn channels-members-user-id-view-post-with-http-info
  "View channel
  Perform all the actions involved in viewing a channel. This includes marking channels as read, clearing push notifications, and updating the active channel.
##### Permissions
Must be logged in as user or have `edit_other_users` permission.

__Response only includes `last_viewed_at_times` in Mattermost server 4.3 and newer.__"
  ([user-id ] (channels-members-user-id-view-post-with-http-info user-id nil))
  ([user-id {:keys [inline-object-40 ]}]
   (check-required-params user-id)
   (call-api "/channels/members/{user_id}/view" :post
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-40
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-members-user-id-view-post
  "View channel
  Perform all the actions involved in viewing a channel. This includes marking channels as read, clearing push notifications, and updating the active channel.
##### Permissions
Must be logged in as user or have `edit_other_users` permission.

__Response only includes `last_viewed_at_times` in Mattermost server 4.3 and newer.__"
  ([user-id ] (channels-members-user-id-view-post user-id nil))
  ([user-id optional-params]
   (:data (channels-members-user-id-view-post-with-http-info user-id optional-params))))

(defn channels-post-with-http-info
  "Create a channel
  Create a new channel.
##### Permissions
If creating a public channel, `create_public_channel` permission is required. If creating a private channel, `create_private_channel` permission is required."
  ([] (channels-post-with-http-info nil))
  ([{:keys [inline-object-32 ]}]
   (call-api "/channels" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-32
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn channels-post
  "Create a channel
  Create a new channel.
##### Permissions
If creating a public channel, `create_public_channel` permission is required. If creating a private channel, `create_private_channel` permission is required."
  ([] (channels-post nil))
  ([optional-params]
   (:data (channels-post-with-http-info optional-params))))

(defn group-search-post-with-http-info
  "Search Group Channels
  Get a list of group channels for a user which members' usernames match the search term.

__Minimum server version__: 5.14"
  ([] (group-search-post-with-http-info nil))
  ([{:keys [inline-object-33 ]}]
   (call-api "/group/search" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-33
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn group-search-post
  "Search Group Channels
  Get a list of group channels for a user which members' usernames match the search term.

__Minimum server version__: 5.14"
  ([] (group-search-post nil))
  ([optional-params]
   (:data (group-search-post-with-http-info optional-params))))

(defn teams-name-team-name-channels-name-channel-name-get-with-http-info
  "Get a channel by name and team name
  Gets a channel from the provided team name and channel name strings.
##### Permissions
`read_channel` permission for the channel."
  ([team-name channel-name ] (teams-name-team-name-channels-name-channel-name-get-with-http-info team-name channel-name nil))
  ([team-name channel-name {:keys [include-deleted ]}]
   (check-required-params team-name channel-name)
   (call-api "/teams/name/{team_name}/channels/name/{channel_name}" :get
             {:path-params   {"team_name" team-name "channel_name" channel-name }
              :header-params {}
              :query-params  {"include_deleted" include-deleted }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-name-team-name-channels-name-channel-name-get
  "Get a channel by name and team name
  Gets a channel from the provided team name and channel name strings.
##### Permissions
`read_channel` permission for the channel."
  ([team-name channel-name ] (teams-name-team-name-channels-name-channel-name-get team-name channel-name nil))
  ([team-name channel-name optional-params]
   (:data (teams-name-team-name-channels-name-channel-name-get-with-http-info team-name channel-name optional-params))))

(defn teams-team-id-channels-autocomplete-get-with-http-info
  "Autocomplete channels
  Autocomplete public channels on a team based on the search term provided in the request URL.

__Minimum server version__: 4.7

##### Permissions
Must have the `list_team_channels` permission."
  [team-id name ]
  (check-required-params team-id name)
  (call-api "/teams/{team_id}/channels/autocomplete" :get
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {"name" name }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-channels-autocomplete-get
  "Autocomplete channels
  Autocomplete public channels on a team based on the search term provided in the request URL.

__Minimum server version__: 4.7

##### Permissions
Must have the `list_team_channels` permission."
  [team-id name ]
  (:data (teams-team-id-channels-autocomplete-get-with-http-info team-id name)))

(defn teams-team-id-channels-deleted-get-with-http-info
  "Get deleted channels
  Get a page of deleted channels on a team based on query string parameters - team_id, page and per_page.

__Minimum server version__: 3.10

##### Permissions
Must be authenticated and have the `manage_team` permission."
  ([team-id ] (teams-team-id-channels-deleted-get-with-http-info team-id nil))
  ([team-id {:keys [page per-page ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/channels/deleted" :get
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-channels-deleted-get
  "Get deleted channels
  Get a page of deleted channels on a team based on query string parameters - team_id, page and per_page.

__Minimum server version__: 3.10

##### Permissions
Must be authenticated and have the `manage_team` permission."
  ([team-id ] (teams-team-id-channels-deleted-get team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-channels-deleted-get-with-http-info team-id optional-params))))

(defn teams-team-id-channels-get-with-http-info
  "Get public channels
  Get a page of public channels on a team based on query string parameters - page and per_page.
##### Permissions
Must be authenticated and have the `list_team_channels` permission."
  ([team-id ] (teams-team-id-channels-get-with-http-info team-id nil))
  ([team-id {:keys [page per-page ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/channels" :get
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-channels-get
  "Get public channels
  Get a page of public channels on a team based on query string parameters - page and per_page.
##### Permissions
Must be authenticated and have the `list_team_channels` permission."
  ([team-id ] (teams-team-id-channels-get team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-channels-get-with-http-info team-id optional-params))))

(defn teams-team-id-channels-ids-post-with-http-info
  "Get a list of channels by ids
  Get a list of public channels on a team by id.
##### Permissions
`view_team` for the team the channels are on."
  [team-id string ]
  (check-required-params team-id string)
  (call-api "/teams/{team_id}/channels/ids" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-channels-ids-post
  "Get a list of channels by ids
  Get a list of public channels on a team by id.
##### Permissions
`view_team` for the team the channels are on."
  [team-id string ]
  (:data (teams-team-id-channels-ids-post-with-http-info team-id string)))

(defn teams-team-id-channels-name-channel-name-get-with-http-info
  "Get a channel by name
  Gets channel from the provided team id and channel name strings.
##### Permissions
`read_channel` permission for the channel."
  ([team-id channel-name ] (teams-team-id-channels-name-channel-name-get-with-http-info team-id channel-name nil))
  ([team-id channel-name {:keys [include-deleted ]}]
   (check-required-params team-id channel-name)
   (call-api "/teams/{team_id}/channels/name/{channel_name}" :get
             {:path-params   {"team_id" team-id "channel_name" channel-name }
              :header-params {}
              :query-params  {"include_deleted" include-deleted }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-channels-name-channel-name-get
  "Get a channel by name
  Gets channel from the provided team id and channel name strings.
##### Permissions
`read_channel` permission for the channel."
  ([team-id channel-name ] (teams-team-id-channels-name-channel-name-get team-id channel-name nil))
  ([team-id channel-name optional-params]
   (:data (teams-team-id-channels-name-channel-name-get-with-http-info team-id channel-name optional-params))))

(defn teams-team-id-channels-search-autocomplete-get-with-http-info
  "Autocomplete channels for search
  Autocomplete your channels on a team based on the search term provided in the request URL.

__Minimum server version__: 5.4

##### Permissions
Must have the `list_team_channels` permission."
  [team-id name ]
  (check-required-params team-id name)
  (call-api "/teams/{team_id}/channels/search_autocomplete" :get
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {"name" name }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-channels-search-autocomplete-get
  "Autocomplete channels for search
  Autocomplete your channels on a team based on the search term provided in the request URL.

__Minimum server version__: 5.4

##### Permissions
Must have the `list_team_channels` permission."
  [team-id name ]
  (:data (teams-team-id-channels-search-autocomplete-get-with-http-info team-id name)))

(defn teams-team-id-channels-search-post-with-http-info
  "Search channels
  Search public channels on a team based on the search term provided in the request body.
##### Permissions
Must have the `list_team_channels` permission.

In server version 5.16 and later, a user without the `list_team_channels` permission will be able to use this endpoint, with the search results limited to the channels that the user is a member of."
  ([team-id ] (teams-team-id-channels-search-post-with-http-info team-id nil))
  ([team-id {:keys [inline-object-36 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/channels/search" :post
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-36
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-channels-search-post
  "Search channels
  Search public channels on a team based on the search term provided in the request body.
##### Permissions
Must have the `list_team_channels` permission.

In server version 5.16 and later, a user without the `list_team_channels` permission will be able to use this endpoint, with the search results limited to the channels that the user is a member of."
  ([team-id ] (teams-team-id-channels-search-post team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-channels-search-post-with-http-info team-id optional-params))))

(defn users-user-id-channels-channel-id-unread-get-with-http-info
  "Get unread messages
  Get the total unread messages and mentions for a channel for a user.
##### Permissions
Must be logged in as user and have the `read_channel` permission, or have `edit_other_usrs` permission."
  [user-id channel-id ]
  (check-required-params user-id channel-id)
  (call-api "/users/{user_id}/channels/{channel_id}/unread" :get
            {:path-params   {"user_id" user-id "channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-channels-channel-id-unread-get
  "Get unread messages
  Get the total unread messages and mentions for a channel for a user.
##### Permissions
Must be logged in as user and have the `read_channel` permission, or have `edit_other_usrs` permission."
  [user-id channel-id ]
  (:data (users-user-id-channels-channel-id-unread-get-with-http-info user-id channel-id)))

(defn users-user-id-teams-team-id-channels-get-with-http-info
  "Get channels for user
  Get all the channels on a team for a user.
##### Permissions
Logged in as the user, or have `edit_other_users` permission, and `view_team` permission for the team."
  [user-id team-id ]
  (check-required-params user-id team-id)
  (call-api "/users/{user_id}/teams/{team_id}/channels" :get
            {:path-params   {"user_id" user-id "team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-teams-team-id-channels-get
  "Get channels for user
  Get all the channels on a team for a user.
##### Permissions
Logged in as the user, or have `edit_other_users` permission, and `view_team` permission for the team."
  [user-id team-id ]
  (:data (users-user-id-teams-team-id-channels-get-with-http-info user-id team-id)))

(defn users-user-id-teams-team-id-channels-members-get-with-http-info
  "Get channel members for user
  Get all channel members on a team for a user.
##### Permissions
Logged in as the user and `view_team` permission for the team. Having `manage_system` permission voids the previous requirements."
  [user-id team-id ]
  (check-required-params user-id team-id)
  (call-api "/users/{user_id}/teams/{team_id}/channels/members" :get
            {:path-params   {"user_id" user-id "team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-teams-team-id-channels-members-get
  "Get channel members for user
  Get all channel members on a team for a user.
##### Permissions
Logged in as the user and `view_team` permission for the team. Having `manage_system` permission voids the previous requirements."
  [user-id team-id ]
  (:data (users-user-id-teams-team-id-channels-members-get-with-http-info user-id team-id)))

