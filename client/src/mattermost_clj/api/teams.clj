(ns mattermost-clj.api.teams
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn teams-get-with-http-info
  "Get teams
  For regular users only returns open teams. Users with the \"manage_system\" permission will return teams regardless of type. The result is based on query string parameters - page and per_page.
##### Permissions
Must be authenticated. \"manage_system\" permission is required to show all teams."
  ([] (teams-get-with-http-info nil))
  ([{:keys [page per-page include-total-count ]}]
   (call-api "/teams" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page "include_total_count" include-total-count }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-get
  "Get teams
  For regular users only returns open teams. Users with the \"manage_system\" permission will return teams regardless of type. The result is based on query string parameters - page and per_page.
##### Permissions
Must be authenticated. \"manage_system\" permission is required to show all teams."
  ([] (teams-get nil))
  ([optional-params]
   (:data (teams-get-with-http-info optional-params))))

(defn teams-invite-invite-id-get-with-http-info
  "Get invite info for a team
  Get the `name`, `display_name`, `description` and `id` for a team from the invite id.

__Minimum server version__: 4.0

##### Permissions
No authentication required."
  [invite-id ]
  (check-required-params invite-id)
  (call-api "/teams/invite/{invite_id}" :get
            {:path-params   {"invite_id" invite-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-invite-invite-id-get
  "Get invite info for a team
  Get the `name`, `display_name`, `description` and `id` for a team from the invite id.

__Minimum server version__: 4.0

##### Permissions
No authentication required."
  [invite-id ]
  (:data (teams-invite-invite-id-get-with-http-info invite-id)))

(defn teams-invites-email-delete-with-http-info
  "Invalidate active email invitations
  Invalidate active email invitations that have not been accepted by the user.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/teams/invites/email" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-invites-email-delete
  "Invalidate active email invitations
  Invalidate active email invitations that have not been accepted by the user.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (teams-invites-email-delete-with-http-info)))

(defn teams-members-invite-post-with-http-info
  "Add user to team from invite
  Using either an invite id or hash/data pair from an email invite link, add a user to a team.
##### Permissions
Must be authenticated."
  [token ]
  (check-required-params token)
  (call-api "/teams/members/invite" :post
            {:path-params   {}
             :header-params {}
             :query-params  {"token" token }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-members-invite-post
  "Add user to team from invite
  Using either an invite id or hash/data pair from an email invite link, add a user to a team.
##### Permissions
Must be authenticated."
  [token ]
  (:data (teams-members-invite-post-with-http-info token)))

(defn teams-name-name-exists-get-with-http-info
  "Check if team exists
  Check if the team exists based on a team name.
##### Permissions
Must be authenticated."
  [name ]
  (check-required-params name)
  (call-api "/teams/name/{name}/exists" :get
            {:path-params   {"name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-name-name-exists-get
  "Check if team exists
  Check if the team exists based on a team name.
##### Permissions
Must be authenticated."
  [name ]
  (:data (teams-name-name-exists-get-with-http-info name)))

(defn teams-name-name-get-with-http-info
  "Get a team by name
  Get a team based on provided name string
##### Permissions
Must be authenticated, team type is open and have the `view_team` permission."
  [name ]
  (check-required-params name)
  (call-api "/teams/name/{name}" :get
            {:path-params   {"name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-name-name-get
  "Get a team by name
  Get a team based on provided name string
##### Permissions
Must be authenticated, team type is open and have the `view_team` permission."
  [name ]
  (:data (teams-name-name-get-with-http-info name)))

(defn teams-post-with-http-info
  "Create a team
  Create a new team on the system.
##### Permissions
Must be authenticated and have the `create_team` permission."
  ([] (teams-post-with-http-info nil))
  ([{:keys [inline-object-23 ]}]
   (call-api "/teams" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-23
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-post
  "Create a team
  Create a new team on the system.
##### Permissions
Must be authenticated and have the `create_team` permission."
  ([] (teams-post nil))
  ([optional-params]
   (:data (teams-post-with-http-info optional-params))))

(defn teams-search-post-with-http-info
  "Search teams
  Search teams based on search term provided in the request body.
##### Permissions
Logged in user only shows open teams
Logged in user with \"manage_system\" permission shows all teams"
  ([] (teams-search-post-with-http-info nil))
  ([{:keys [inline-object-26 ]}]
   (call-api "/teams/search" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-26
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-search-post
  "Search teams
  Search teams based on search term provided in the request body.
##### Permissions
Logged in user only shows open teams
Logged in user with \"manage_system\" permission shows all teams"
  ([] (teams-search-post nil))
  ([optional-params]
   (:data (teams-search-post-with-http-info optional-params))))

(defn teams-team-id-delete-with-http-info
  "Delete a team
  Soft deletes a team, by marking the team as deleted in the database. Soft deleted teams will not be accessible in the user interface.

Optionally use the permanent query parameter to hard delete the team for compliance reasons. As of server version 5.0, to use this feature `ServiceSettings.EnableAPITeamDeletion` must be set to `true` in the server's configuration.
##### Permissions
Must have the `manage_team` permission."
  ([team-id ] (teams-team-id-delete-with-http-info team-id nil))
  ([team-id {:keys [permanent ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}" :delete
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {"permanent" permanent }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-delete
  "Delete a team
  Soft deletes a team, by marking the team as deleted in the database. Soft deleted teams will not be accessible in the user interface.

Optionally use the permanent query parameter to hard delete the team for compliance reasons. As of server version 5.0, to use this feature `ServiceSettings.EnableAPITeamDeletion` must be set to `true` in the server's configuration.
##### Permissions
Must have the `manage_team` permission."
  ([team-id ] (teams-team-id-delete team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-delete-with-http-info team-id optional-params))))

(defn teams-team-id-get-with-http-info
  "Get a team
  Get a team on the system.
##### Permissions
Must be authenticated and have the `view_team` permission."
  [team-id ]
  (check-required-params team-id)
  (call-api "/teams/{team_id}" :get
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-get
  "Get a team
  Get a team on the system.
##### Permissions
Must be authenticated and have the `view_team` permission."
  [team-id ]
  (:data (teams-team-id-get-with-http-info team-id)))

(defn teams-team-id-image-delete-with-http-info
  "Remove the team icon
  Remove the team icon for the team.

__Minimum server version__: 4.10

##### Permissions
Must be authenticated and have the `manage_team` permission."
  [team-id ]
  (check-required-params team-id)
  (call-api "/teams/{team_id}/image" :delete
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-image-delete
  "Remove the team icon
  Remove the team icon for the team.

__Minimum server version__: 4.10

##### Permissions
Must be authenticated and have the `manage_team` permission."
  [team-id ]
  (:data (teams-team-id-image-delete-with-http-info team-id)))

(defn teams-team-id-image-get-with-http-info
  "Get the team icon
  Get the team icon of the team.

__Minimum server version__: 4.9

##### Permissions
User must be authenticated. In addition, team must be open or the user must have the `view_team` permission."
  [team-id ]
  (check-required-params team-id)
  (call-api "/teams/{team_id}/image" :get
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-image-get
  "Get the team icon
  Get the team icon of the team.

__Minimum server version__: 4.9

##### Permissions
User must be authenticated. In addition, team must be open or the user must have the `view_team` permission."
  [team-id ]
  (:data (teams-team-id-image-get-with-http-info team-id)))

(defn teams-team-id-image-post-with-http-info
  "Sets the team icon
  Sets the team icon for the team.

__Minimum server version__: 4.9

##### Permissions
Must be authenticated and have the `manage_team` permission."
  [team-id ^File image ]
  (check-required-params team-id image)
  (call-api "/teams/{team_id}/image" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {"image" image }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-image-post
  "Sets the team icon
  Sets the team icon for the team.

__Minimum server version__: 4.9

##### Permissions
Must be authenticated and have the `manage_team` permission."
  [team-id ^File image ]
  (:data (teams-team-id-image-post-with-http-info team-id image)))

(defn teams-team-id-import-post-with-http-info
  "Import a Team from other application
  Import a team into a existing team. Import users, channels, posts, hooks.
##### Permissions
Must have `permission_import_team` permission."
  [team-id ^File file filesize import-from ]
  (check-required-params team-id file filesize import-from)
  (call-api "/teams/{team_id}/import" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {"file" file "filesize" filesize "importFrom" import-from }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-import-post
  "Import a Team from other application
  Import a team into a existing team. Import users, channels, posts, hooks.
##### Permissions
Must have `permission_import_team` permission."
  [team-id ^File file filesize import-from ]
  (:data (teams-team-id-import-post-with-http-info team-id file filesize import-from)))

(defn teams-team-id-invite-email-post-with-http-info
  "Invite users to the team by email
  Invite users to the existing team usign the user's email.
##### Permissions
Must have `invite_to_team` permission for the team."
  [team-id string ]
  (check-required-params team-id string)
  (call-api "/teams/{team_id}/invite/email" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-invite-email-post
  "Invite users to the team by email
  Invite users to the existing team usign the user's email.
##### Permissions
Must have `invite_to_team` permission for the team."
  [team-id string ]
  (:data (teams-team-id-invite-email-post-with-http-info team-id string)))

(defn teams-team-id-invite-guests-email-post-with-http-info
  "Invite guests to the team by email
  Invite guests to existing team channels usign the user's email.

__Minimum server version__: 5.16

##### Permissions
Must have `invite_guest` permission for the team."
  ([team-id ] (teams-team-id-invite-guests-email-post-with-http-info team-id nil))
  ([team-id {:keys [inline-object-30 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/invite-guests/email" :post
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-30
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-invite-guests-email-post
  "Invite guests to the team by email
  Invite guests to existing team channels usign the user's email.

__Minimum server version__: 5.16

##### Permissions
Must have `invite_guest` permission for the team."
  ([team-id ] (teams-team-id-invite-guests-email-post team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-invite-guests-email-post-with-http-info team-id optional-params))))

(defn teams-team-id-members-batch-post-with-http-info
  "Add multiple users to team
  Add a number of users to the team by user_id.
##### Permissions
Must be authenticated. Authenticated user must have the `add_user_to_team` permission."
  [team-id team-member ]
  (check-required-params team-id team-member)
  (call-api "/teams/{team_id}/members/batch" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    team-member
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-members-batch-post
  "Add multiple users to team
  Add a number of users to the team by user_id.
##### Permissions
Must be authenticated. Authenticated user must have the `add_user_to_team` permission."
  [team-id team-member ]
  (:data (teams-team-id-members-batch-post-with-http-info team-id team-member)))

(defn teams-team-id-members-get-with-http-info
  "Get team members
  Get a page team members list based on query string parameters - team id, page and per page.
##### Permissions
Must be authenticated and have the `view_team` permission."
  ([team-id ] (teams-team-id-members-get-with-http-info team-id nil))
  ([team-id {:keys [page per-page ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/members" :get
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-members-get
  "Get team members
  Get a page team members list based on query string parameters - team id, page and per page.
##### Permissions
Must be authenticated and have the `view_team` permission."
  ([team-id ] (teams-team-id-members-get team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-members-get-with-http-info team-id optional-params))))

(defn teams-team-id-members-ids-post-with-http-info
  "Get team members by ids
  Get a list of team members based on a provided array of user ids.
##### Permissions
Must have `view_team` permission for the team."
  [team-id string ]
  (check-required-params team-id string)
  (call-api "/teams/{team_id}/members/ids" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-members-ids-post
  "Get team members by ids
  Get a list of team members based on a provided array of user ids.
##### Permissions
Must have `view_team` permission for the team."
  [team-id string ]
  (:data (teams-team-id-members-ids-post-with-http-info team-id string)))

(defn teams-team-id-members-minus-group-members-get-with-http-info
  "Team members minus group members.
  Get the set of users who are members of the team minus the set of users who are members of the given groups.
Each user object contains an array of group objects representing the group memberships for that user.
Each user object contains the boolean fields `scheme_guest`, `scheme_user`, and `scheme_admin` representing the roles that user has for the given team.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.14"
  ([team-id group-ids ] (teams-team-id-members-minus-group-members-get-with-http-info team-id group-ids nil))
  ([team-id group-ids {:keys [page per-page ]}]
   (check-required-params team-id group-ids)
   (call-api "/teams/{team_id}/members_minus_group_members" :get
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {"group_ids" group-ids "page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-members-minus-group-members-get
  "Team members minus group members.
  Get the set of users who are members of the team minus the set of users who are members of the given groups.
Each user object contains an array of group objects representing the group memberships for that user.
Each user object contains the boolean fields `scheme_guest`, `scheme_user`, and `scheme_admin` representing the roles that user has for the given team.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.14"
  ([team-id group-ids ] (teams-team-id-members-minus-group-members-get team-id group-ids nil))
  ([team-id group-ids optional-params]
   (:data (teams-team-id-members-minus-group-members-get-with-http-info team-id group-ids optional-params))))

(defn teams-team-id-members-post-with-http-info
  "Add user to team
  Add user to the team by user_id.
##### Permissions
Must be authenticated and team be open to add self. For adding another user, authenticated user must have the `add_user_to_team` permission."
  ([team-id ] (teams-team-id-members-post-with-http-info team-id nil))
  ([team-id {:keys [inline-object-27 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/members" :post
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-27
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-members-post
  "Add user to team
  Add user to the team by user_id.
##### Permissions
Must be authenticated and team be open to add self. For adding another user, authenticated user must have the `add_user_to_team` permission."
  ([team-id ] (teams-team-id-members-post team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-members-post-with-http-info team-id optional-params))))

(defn teams-team-id-members-user-id-delete-with-http-info
  "Remove user from team
  Delete the team member object for a user, effectively removing them from a team.
##### Permissions
Must be logged in as the user or have the `remove_user_from_team` permission."
  [team-id user-id ]
  (check-required-params team-id user-id)
  (call-api "/teams/{team_id}/members/{user_id}" :delete
            {:path-params   {"team_id" team-id "user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-members-user-id-delete
  "Remove user from team
  Delete the team member object for a user, effectively removing them from a team.
##### Permissions
Must be logged in as the user or have the `remove_user_from_team` permission."
  [team-id user-id ]
  (:data (teams-team-id-members-user-id-delete-with-http-info team-id user-id)))

(defn teams-team-id-members-user-id-get-with-http-info
  "Get a team member
  Get a team member on the system.
##### Permissions
Must be authenticated and have the `view_team` permission."
  [team-id user-id ]
  (check-required-params team-id user-id)
  (call-api "/teams/{team_id}/members/{user_id}" :get
            {:path-params   {"team_id" team-id "user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-members-user-id-get
  "Get a team member
  Get a team member on the system.
##### Permissions
Must be authenticated and have the `view_team` permission."
  [team-id user-id ]
  (:data (teams-team-id-members-user-id-get-with-http-info team-id user-id)))

(defn teams-team-id-members-user-id-roles-put-with-http-info
  "Update a team member roles
  Update a team member roles. Valid team roles are \"team_user\", \"team_admin\" or both of them. Overwrites any previously assigned team roles.
##### Permissions
Must be authenticated and have the `manage_team_roles` permission."
  ([team-id user-id ] (teams-team-id-members-user-id-roles-put-with-http-info team-id user-id nil))
  ([team-id user-id {:keys [inline-object-28 ]}]
   (check-required-params team-id user-id)
   (call-api "/teams/{team_id}/members/{user_id}/roles" :put
             {:path-params   {"team_id" team-id "user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-28
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-members-user-id-roles-put
  "Update a team member roles
  Update a team member roles. Valid team roles are \"team_user\", \"team_admin\" or both of them. Overwrites any previously assigned team roles.
##### Permissions
Must be authenticated and have the `manage_team_roles` permission."
  ([team-id user-id ] (teams-team-id-members-user-id-roles-put team-id user-id nil))
  ([team-id user-id optional-params]
   (:data (teams-team-id-members-user-id-roles-put-with-http-info team-id user-id optional-params))))

(defn teams-team-id-members-user-id-scheme-roles-put-with-http-info
  "Update the scheme-derived roles of a team member.
  Update a team member's scheme_admin/scheme_user properties. Typically this should either be `scheme_admin=false, scheme_user=true` for ordinary team member, or `scheme_admin=true, scheme_user=true` for a team admin.

__Minimum server version__: 5.0

##### Permissions
Must be authenticated and have the `manage_team_roles` permission."
  ([team-id user-id ] (teams-team-id-members-user-id-scheme-roles-put-with-http-info team-id user-id nil))
  ([team-id user-id {:keys [inline-object-29 ]}]
   (check-required-params team-id user-id)
   (call-api "/teams/{team_id}/members/{user_id}/schemeRoles" :put
             {:path-params   {"team_id" team-id "user_id" user-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-29
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-members-user-id-scheme-roles-put
  "Update the scheme-derived roles of a team member.
  Update a team member's scheme_admin/scheme_user properties. Typically this should either be `scheme_admin=false, scheme_user=true` for ordinary team member, or `scheme_admin=true, scheme_user=true` for a team admin.

__Minimum server version__: 5.0

##### Permissions
Must be authenticated and have the `manage_team_roles` permission."
  ([team-id user-id ] (teams-team-id-members-user-id-scheme-roles-put team-id user-id nil))
  ([team-id user-id optional-params]
   (:data (teams-team-id-members-user-id-scheme-roles-put-with-http-info team-id user-id optional-params))))

(defn teams-team-id-patch-put-with-http-info
  "Patch a team
  Partially update a team by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have the `manage_team` permission."
  ([team-id ] (teams-team-id-patch-put-with-http-info team-id nil))
  ([team-id {:keys [inline-object-25 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/patch" :put
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-25
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-patch-put
  "Patch a team
  Partially update a team by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have the `manage_team` permission."
  ([team-id ] (teams-team-id-patch-put team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-patch-put-with-http-info team-id optional-params))))

(defn teams-team-id-put-with-http-info
  "Update a team
  Update a team by providing the team object. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have the `manage_team` permission."
  ([team-id ] (teams-team-id-put-with-http-info team-id nil))
  ([team-id {:keys [inline-object-24 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}" :put
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-24
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-put
  "Update a team
  Update a team by providing the team object. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have the `manage_team` permission."
  ([team-id ] (teams-team-id-put team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-put-with-http-info team-id optional-params))))

(defn teams-team-id-regenerate-invite-id-post-with-http-info
  "Regenerate the Invite ID from a Team
  Regenerates the invite ID used in invite links of a team
##### Permissions
Must be authenticated and have the `manage_team` permission."
  [team-id ]
  (check-required-params team-id)
  (call-api "/teams/{team_id}/regenerate_invite_id" :post
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-regenerate-invite-id-post
  "Regenerate the Invite ID from a Team
  Regenerates the invite ID used in invite links of a team
##### Permissions
Must be authenticated and have the `manage_team` permission."
  [team-id ]
  (:data (teams-team-id-regenerate-invite-id-post-with-http-info team-id)))

(defn teams-team-id-scheme-put-with-http-info
  "Set a team's scheme
  Set a team's scheme, more specifically sets the scheme_id value of a team record.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  ([team-id ] (teams-team-id-scheme-put-with-http-info team-id nil))
  ([team-id {:keys [inline-object-31 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/scheme" :put
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-31
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["api_key"]})))

(defn teams-team-id-scheme-put
  "Set a team's scheme
  Set a team's scheme, more specifically sets the scheme_id value of a team record.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.0"
  ([team-id ] (teams-team-id-scheme-put team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-scheme-put-with-http-info team-id optional-params))))

(defn teams-team-id-stats-get-with-http-info
  "Get a team stats
  Get a team stats on the system.
##### Permissions
Must be authenticated and have the `view_team` permission."
  [team-id ]
  (check-required-params team-id)
  (call-api "/teams/{team_id}/stats" :get
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn teams-team-id-stats-get
  "Get a team stats
  Get a team stats on the system.
##### Permissions
Must be authenticated and have the `view_team` permission."
  [team-id ]
  (:data (teams-team-id-stats-get-with-http-info team-id)))

(defn users-user-id-teams-get-with-http-info
  "Get a user's teams
  Get a list of teams that a user is on.
##### Permissions
Must be authenticated as the user or have the `manage_system` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/teams" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-teams-get
  "Get a user's teams
  Get a list of teams that a user is on.
##### Permissions
Must be authenticated as the user or have the `manage_system` permission."
  [user-id ]
  (:data (users-user-id-teams-get-with-http-info user-id)))

(defn users-user-id-teams-members-get-with-http-info
  "Get team members for a user
  Get a list of team members for a user. Useful for getting the ids of teams the user is on and the roles they have in those teams.
##### Permissions
Must be logged in as the user or have the `edit_other_users` permission."
  [user-id ]
  (check-required-params user-id)
  (call-api "/users/{user_id}/teams/members" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-teams-members-get
  "Get team members for a user
  Get a list of team members for a user. Useful for getting the ids of teams the user is on and the roles they have in those teams.
##### Permissions
Must be logged in as the user or have the `edit_other_users` permission."
  [user-id ]
  (:data (users-user-id-teams-members-get-with-http-info user-id)))

(defn users-user-id-teams-team-id-unread-get-with-http-info
  "Get unreads for a team
  Get the unread mention and message counts for a team for the specified user.
##### Permissions
Must be the user or have `edit_other_users` permission and have `view_team` permission for the team."
  [user-id team-id ]
  (check-required-params user-id team-id)
  (call-api "/users/{user_id}/teams/{team_id}/unread" :get
            {:path-params   {"user_id" user-id "team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-teams-team-id-unread-get
  "Get unreads for a team
  Get the unread mention and message counts for a team for the specified user.
##### Permissions
Must be the user or have `edit_other_users` permission and have `view_team` permission for the team."
  [user-id team-id ]
  (:data (users-user-id-teams-team-id-unread-get-with-http-info user-id team-id)))

(defn users-user-id-teams-unread-get-with-http-info
  "Get team unreads for a user
  Get the count for unread messages and mentions in the teams the user is a member of.
##### Permissions
Must be logged in."
  [user-id exclude-team ]
  (check-required-params user-id exclude-team)
  (call-api "/users/{user_id}/teams/unread" :get
            {:path-params   {"user_id" user-id }
             :header-params {}
             :query-params  {"exclude_team" exclude-team }
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    ["api_key"]}))

(defn users-user-id-teams-unread-get
  "Get team unreads for a user
  Get the count for unread messages and mentions in the teams the user is a member of.
##### Permissions
Must be logged in."
  [user-id exclude-team ]
  (:data (users-user-id-teams-unread-get-with-http-info user-id exclude-team)))

