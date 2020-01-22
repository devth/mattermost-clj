(ns mattermost-clj.api.groups
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn channels-channel-id-groups-get-with-http-info
  "Get channel groups
  Retrieve the list of groups associated with a given channel.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([channel-id ] (channels-channel-id-groups-get-with-http-info channel-id nil))
  ([channel-id {:keys [page per-page ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}/groups" :get
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn channels-channel-id-groups-get
  "Get channel groups
  Retrieve the list of groups associated with a given channel.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([channel-id ] (channels-channel-id-groups-get channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-groups-get-with-http-info channel-id optional-params))))

(defn groups-get-with-http-info
  "Get groups
  Retrieve the list of groups.

__Minimum server version__: 5.11"
  ([] (groups-get-with-http-info nil))
  ([{:keys [page per-page q include-member-count not-associated-to-team not-associated-to-channel ]}]
   (call-api "/groups" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "q" q "include_member_count" include-member-count "not_associated_to_team" not-associated-to-team "not_associated_to_channel" not-associated-to-channel }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn groups-get
  "Get groups
  Retrieve the list of groups.

__Minimum server version__: 5.11"
  ([] (groups-get nil))
  ([optional-params]
   (:data (groups-get-with-http-info optional-params))))

(defn groups-group-id-channels-channel-id-get-with-http-info
  "Get GroupSyncable from channel ID
  Get the GroupSyncable object with group_id and channel_id from params
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id channel-id ]
  (check-required-params group-id channel-id)
  (call-api "/groups/{group_id}/channels/{channel_id}" :get
            {:path-params   {"group_id" group-id "channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-channels-channel-id-get
  "Get GroupSyncable from channel ID
  Get the GroupSyncable object with group_id and channel_id from params
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id channel-id ]
  (:data (groups-group-id-channels-channel-id-get-with-http-info group-id channel-id)))

(defn groups-group-id-channels-channel-id-link-delete-with-http-info
  "Delete a link from a channel to a group
  Delete a link from a channel to a group
##### Permissions
If the channel is private, you must have `manage_private_channel_members` permission.
Otherwise, you must have the `manage_public_channel_members` permission.

__Minimum server version__: 5.11"
  [group-id channel-id ]
  (check-required-params group-id channel-id)
  (call-api "/groups/{group_id}/channels/{channel_id}/link" :delete
            {:path-params   {"group_id" group-id "channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-channels-channel-id-link-delete
  "Delete a link from a channel to a group
  Delete a link from a channel to a group
##### Permissions
If the channel is private, you must have `manage_private_channel_members` permission.
Otherwise, you must have the `manage_public_channel_members` permission.

__Minimum server version__: 5.11"
  [group-id channel-id ]
  (:data (groups-group-id-channels-channel-id-link-delete-with-http-info group-id channel-id)))

(defn groups-group-id-channels-channel-id-link-post-with-http-info
  "Link a channel to a group
  Link a channel to a group
##### Permissions
If the channel is private, you must have `manage_private_channel_members` permission.
Otherwise, you must have the `manage_public_channel_members` permission.

__Minimum server version__: 5.11"
  [group-id channel-id ]
  (check-required-params group-id channel-id)
  (call-api "/groups/{group_id}/channels/{channel_id}/link" :post
            {:path-params   {"group_id" group-id "channel_id" channel-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-channels-channel-id-link-post
  "Link a channel to a group
  Link a channel to a group
##### Permissions
If the channel is private, you must have `manage_private_channel_members` permission.
Otherwise, you must have the `manage_public_channel_members` permission.

__Minimum server version__: 5.11"
  [group-id channel-id ]
  (:data (groups-group-id-channels-channel-id-link-post-with-http-info group-id channel-id)))

(defn groups-group-id-channels-channel-id-patch-put-with-http-info
  "Patch a GroupSyncable associated to Channel
  Partially update a GroupSyncable by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id channel-id ] (groups-group-id-channels-channel-id-patch-put-with-http-info group-id channel-id nil))
  ([group-id channel-id {:keys [inline-object-57 ]}]
   (check-required-params group-id channel-id)
   (call-api "/groups/{group_id}/channels/{channel_id}/patch" :put
             {:path-params   {"group_id" group-id "channel_id" channel-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-57
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn groups-group-id-channels-channel-id-patch-put
  "Patch a GroupSyncable associated to Channel
  Partially update a GroupSyncable by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id channel-id ] (groups-group-id-channels-channel-id-patch-put group-id channel-id nil))
  ([group-id channel-id optional-params]
   (:data (groups-group-id-channels-channel-id-patch-put-with-http-info group-id channel-id optional-params))))

(defn groups-group-id-channels-get-with-http-info
  "Get group channels
  Retrieve the list of channels associated to the group
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id ]
  (check-required-params group-id)
  (call-api "/groups/{group_id}/channels" :get
            {:path-params   {"group_id" group-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-channels-get
  "Get group channels
  Retrieve the list of channels associated to the group
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id ]
  (:data (groups-group-id-channels-get-with-http-info group-id)))

(defn groups-group-id-get-with-http-info
  "Get a group
  Get group from the provided group id string

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id ]
  (check-required-params group-id)
  (call-api "/groups/{group_id}" :get
            {:path-params   {"group_id" group-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-get
  "Get a group
  Get group from the provided group id string

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id ]
  (:data (groups-group-id-get-with-http-info group-id)))

(defn groups-group-id-members-get-with-http-info
  "Get group users
  Retrieve the list of users associated with a given group.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id ] (groups-group-id-members-get-with-http-info group-id nil))
  ([group-id {:keys [page per-page ]}]
   (check-required-params group-id)
   (call-api "/groups/{group_id}/members" :get
             {:path-params   {"group_id" group-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn groups-group-id-members-get
  "Get group users
  Retrieve the list of users associated with a given group.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id ] (groups-group-id-members-get group-id nil))
  ([group-id optional-params]
   (:data (groups-group-id-members-get-with-http-info group-id optional-params))))

(defn groups-group-id-patch-put-with-http-info
  "Patch a group
  Partially update a group by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id ] (groups-group-id-patch-put-with-http-info group-id nil))
  ([group-id {:keys [inline-object-55 ]}]
   (check-required-params group-id)
   (call-api "/groups/{group_id}/patch" :put
             {:path-params   {"group_id" group-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-55
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn groups-group-id-patch-put
  "Patch a group
  Partially update a group by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id ] (groups-group-id-patch-put group-id nil))
  ([group-id optional-params]
   (:data (groups-group-id-patch-put-with-http-info group-id optional-params))))

(defn groups-group-id-teams-get-with-http-info
  "Get group teams
  Retrieve the list of teams associated to the group
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id ]
  (check-required-params group-id)
  (call-api "/groups/{group_id}/teams" :get
            {:path-params   {"group_id" group-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-teams-get
  "Get group teams
  Retrieve the list of teams associated to the group
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id ]
  (:data (groups-group-id-teams-get-with-http-info group-id)))

(defn groups-group-id-teams-team-id-get-with-http-info
  "Get GroupSyncable from Team ID
  Get the GroupSyncable object with group_id and team_id from params
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id team-id ]
  (check-required-params group-id team-id)
  (call-api "/groups/{group_id}/teams/{team_id}" :get
            {:path-params   {"group_id" group-id "team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-teams-team-id-get
  "Get GroupSyncable from Team ID
  Get the GroupSyncable object with group_id and team_id from params
##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  [group-id team-id ]
  (:data (groups-group-id-teams-team-id-get-with-http-info group-id team-id)))

(defn groups-group-id-teams-team-id-link-delete-with-http-info
  "Delete a link from a team to a group
  Delete a link from a team to a group
##### Permissions
Must have `manage_team` permission.

__Minimum server version__: 5.11"
  [group-id team-id ]
  (check-required-params group-id team-id)
  (call-api "/groups/{group_id}/teams/{team_id}/link" :delete
            {:path-params   {"group_id" group-id "team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-teams-team-id-link-delete
  "Delete a link from a team to a group
  Delete a link from a team to a group
##### Permissions
Must have `manage_team` permission.

__Minimum server version__: 5.11"
  [group-id team-id ]
  (:data (groups-group-id-teams-team-id-link-delete-with-http-info group-id team-id)))

(defn groups-group-id-teams-team-id-link-post-with-http-info
  "Link a team to a group
  Link a team to a group
##### Permissions
Must have `manage_team` permission.

__Minimum server version__: 5.11"
  [group-id team-id ]
  (check-required-params group-id team-id)
  (call-api "/groups/{group_id}/teams/{team_id}/link" :post
            {:path-params   {"group_id" group-id "team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn groups-group-id-teams-team-id-link-post
  "Link a team to a group
  Link a team to a group
##### Permissions
Must have `manage_team` permission.

__Minimum server version__: 5.11"
  [group-id team-id ]
  (:data (groups-group-id-teams-team-id-link-post-with-http-info group-id team-id)))

(defn groups-group-id-teams-team-id-patch-put-with-http-info
  "Patch a GroupSyncable associated to Team
  Partially update a GroupSyncable by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id team-id ] (groups-group-id-teams-team-id-patch-put-with-http-info group-id team-id nil))
  ([group-id team-id {:keys [inline-object-56 ]}]
   (check-required-params group-id team-id)
   (call-api "/groups/{group_id}/teams/{team_id}/patch" :put
             {:path-params   {"group_id" group-id "team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-56
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn groups-group-id-teams-team-id-patch-put
  "Patch a GroupSyncable associated to Team
  Partially update a GroupSyncable by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([group-id team-id ] (groups-group-id-teams-team-id-patch-put group-id team-id nil))
  ([group-id team-id optional-params]
   (:data (groups-group-id-teams-team-id-patch-put-with-http-info group-id team-id optional-params))))

(defn teams-team-id-groups-get-with-http-info
  "Get team groups
  Retrieve the list of groups associated with a given team.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([team-id ] (teams-team-id-groups-get-with-http-info team-id nil))
  ([team-id {:keys [page per-page ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/groups" :get
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn teams-team-id-groups-get
  "Get team groups
  Retrieve the list of groups associated with a given team.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.11"
  ([team-id ] (teams-team-id-groups-get team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-groups-get-with-http-info team-id optional-params))))

