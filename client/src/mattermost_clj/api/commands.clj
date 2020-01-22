(ns mattermost-clj.api.commands
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn commands-command-id-delete-with-http-info
  "Delete a command
  Delete a command based on command id string.
##### Permissions
Must have `manage_slash_commands` permission for the team the command is in."
  [command-id ]
  (check-required-params command-id)
  (call-api "/commands/{command_id}" :delete
            {:path-params   {"command_id" command-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn commands-command-id-delete
  "Delete a command
  Delete a command based on command id string.
##### Permissions
Must have `manage_slash_commands` permission for the team the command is in."
  [command-id ]
  (:data (commands-command-id-delete-with-http-info command-id)))

(defn commands-command-id-put-with-http-info
  "Update a command
  Update a single command based on command id string and Command struct.
##### Permissions
Must have `manage_slash_commands` permission for the team the command is in."
  [command-id command ]
  (check-required-params command-id command)
  (call-api "/commands/{command_id}" :put
            {:path-params   {"command_id" command-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    command
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn commands-command-id-put
  "Update a command
  Update a single command based on command id string and Command struct.
##### Permissions
Must have `manage_slash_commands` permission for the team the command is in."
  [command-id command ]
  (:data (commands-command-id-put-with-http-info command-id command)))

(defn commands-command-id-regen-token-put-with-http-info
  "Generate a new token
  Generate a new token for the command based on command id string.
##### Permissions
Must have `manage_slash_commands` permission for the team the command is in."
  [command-id ]
  (check-required-params command-id)
  (call-api "/commands/{command_id}/regen_token" :put
            {:path-params   {"command_id" command-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn commands-command-id-regen-token-put
  "Generate a new token
  Generate a new token for the command based on command id string.
##### Permissions
Must have `manage_slash_commands` permission for the team the command is in."
  [command-id ]
  (:data (commands-command-id-regen-token-put-with-http-info command-id)))

(defn commands-execute-post-with-http-info
  "Execute a command
  Execute a command on a team.
##### Permissions
Must have `use_slash_commands` permission for the team the command is in."
  ([] (commands-execute-post-with-http-info nil))
  ([{:keys [inline-object-59 ]}]
   (call-api "/commands/execute" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-59
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn commands-execute-post
  "Execute a command
  Execute a command on a team.
##### Permissions
Must have `use_slash_commands` permission for the team the command is in."
  ([] (commands-execute-post nil))
  ([optional-params]
   (:data (commands-execute-post-with-http-info optional-params))))

(defn commands-get-with-http-info
  "List commands for a team
  List commands for a team.
##### Permissions
`manage_slash_commands` if need list custom commands."
  ([] (commands-get-with-http-info nil))
  ([{:keys [team-id custom-only ]}]
   (call-api "/commands" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"team_id" team-id "custom_only" custom-only }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn commands-get
  "List commands for a team
  List commands for a team.
##### Permissions
`manage_slash_commands` if need list custom commands."
  ([] (commands-get nil))
  ([optional-params]
   (:data (commands-get-with-http-info optional-params))))

(defn commands-post-with-http-info
  "Create a command
  Create a command for a team.
##### Permissions
`manage_slash_commands` for the team the command is in."
  ([] (commands-post-with-http-info nil))
  ([{:keys [inline-object-58 ]}]
   (call-api "/commands" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-58
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn commands-post
  "Create a command
  Create a command for a team.
##### Permissions
`manage_slash_commands` for the team the command is in."
  ([] (commands-post nil))
  ([optional-params]
   (:data (commands-post-with-http-info optional-params))))

(defn teams-team-id-commands-autocomplete-get-with-http-info
  "List autocomplete commands
  List autocomplete commands in the team.
##### Permissions
`view_team` for the team."
  [team-id ]
  (check-required-params team-id)
  (call-api "/teams/{team_id}/commands/autocomplete" :get
            {:path-params   {"team_id" team-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn teams-team-id-commands-autocomplete-get
  "List autocomplete commands
  List autocomplete commands in the team.
##### Permissions
`view_team` for the team."
  [team-id ]
  (:data (teams-team-id-commands-autocomplete-get-with-http-info team-id)))

