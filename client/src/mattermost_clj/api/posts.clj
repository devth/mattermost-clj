(ns mattermost-clj.api.posts
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn channels-channel-id-posts-get-with-http-info
  "Get posts for a channel
  Get a page of posts in a channel. Use the query parameters to modify the behaviour of this endpoint. The parameters `since`, `before` and `after` must not be used together.
##### Permissions
Must have `read_channel` permission for the channel."
  ([channel-id ] (channels-channel-id-posts-get-with-http-info channel-id nil))
  ([channel-id {:keys [page per-page since before after ]}]
   (check-required-params channel-id)
   (call-api "/channels/{channel_id}/posts" :get
             {:path-params   {"channel_id" channel-id }
              :header-params {}
              :query-params  {"page" page "per_page" per-page "since" since "before" before "after" after }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn channels-channel-id-posts-get
  "Get posts for a channel
  Get a page of posts in a channel. Use the query parameters to modify the behaviour of this endpoint. The parameters `since`, `before` and `after` must not be used together.
##### Permissions
Must have `read_channel` permission for the channel."
  ([channel-id ] (channels-channel-id-posts-get channel-id nil))
  ([channel-id optional-params]
   (:data (channels-channel-id-posts-get-with-http-info channel-id optional-params))))

(defn posts-ephemeral-post-with-http-info
  "Create a ephemeral post
  Create a new ephemeral post in a channel.
##### Permissions
Must have `create_post_ephemeral` permission (currently only given to system admin)"
  ([] (posts-ephemeral-post-with-http-info nil))
  ([{:keys [inline-object-43 ]}]
   (call-api "/posts/ephemeral" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-43
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn posts-ephemeral-post
  "Create a ephemeral post
  Create a new ephemeral post in a channel.
##### Permissions
Must have `create_post_ephemeral` permission (currently only given to system admin)"
  ([] (posts-ephemeral-post nil))
  ([optional-params]
   (:data (posts-ephemeral-post-with-http-info optional-params))))

(defn posts-post-with-http-info
  "Create a post
  Create a new post in a channel. To create the post as a comment on another post, provide `root_id`.
##### Permissions
Must have `create_post` permission for the channel the post is being created in."
  ([] (posts-post-with-http-info nil))
  ([{:keys [inline-object-42 ]}]
   (call-api "/posts" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-42
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn posts-post
  "Create a post
  Create a new post in a channel. To create the post as a comment on another post, provide `root_id`.
##### Permissions
Must have `create_post` permission for the channel the post is being created in."
  ([] (posts-post nil))
  ([optional-params]
   (:data (posts-post-with-http-info optional-params))))

(defn posts-post-id-actions-action-id-post-with-http-info
  "Perform a post action
  Perform a post action, which allows users to interact with integrations through posts.
##### Permissions
Must be authenticated and have the `read_channel` permission to the channel the post is in."
  [post-id action-id ]
  (check-required-params post-id action-id)
  (call-api "/posts/{post_id}/actions/{action_id}" :post
            {:path-params   {"post_id" post-id "action_id" action-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-actions-action-id-post
  "Perform a post action
  Perform a post action, which allows users to interact with integrations through posts.
##### Permissions
Must be authenticated and have the `read_channel` permission to the channel the post is in."
  [post-id action-id ]
  (:data (posts-post-id-actions-action-id-post-with-http-info post-id action-id)))

(defn posts-post-id-delete-with-http-info
  "Delete a post
  Soft deletes a post, by marking the post as deleted in the database. Soft deleted posts will not be returned in post queries.
##### Permissions
Must be logged in as the user or have `delete_others_posts` permission."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}" :delete
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-delete
  "Delete a post
  Soft deletes a post, by marking the post as deleted in the database. Soft deleted posts will not be returned in post queries.
##### Permissions
Must be logged in as the user or have `delete_others_posts` permission."
  [post-id ]
  (:data (posts-post-id-delete-with-http-info post-id)))

(defn posts-post-id-files-info-get-with-http-info
  "Get file info for post
  Gets a list of file information objects for the files attached to a post.
##### Permissions
Must have `read_channel` permission for the channel the post is in."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}/files/info" :get
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-files-info-get
  "Get file info for post
  Gets a list of file information objects for the files attached to a post.
##### Permissions
Must have `read_channel` permission for the channel the post is in."
  [post-id ]
  (:data (posts-post-id-files-info-get-with-http-info post-id)))

(defn posts-post-id-get-with-http-info
  "Get a post
  Get a single post.
##### Permissions
Must have `read_channel` permission for the channel the post is in or if the channel is public, have the `read_public_channels` permission for the team."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}" :get
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-get
  "Get a post
  Get a single post.
##### Permissions
Must have `read_channel` permission for the channel the post is in or if the channel is public, have the `read_public_channels` permission for the team."
  [post-id ]
  (:data (posts-post-id-get-with-http-info post-id)))

(defn posts-post-id-patch-put-with-http-info
  "Patch a post
  Partially update a post by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have the `edit_post` permission."
  ([post-id ] (posts-post-id-patch-put-with-http-info post-id nil))
  ([post-id {:keys [inline-object-45 ]}]
   (check-required-params post-id)
   (call-api "/posts/{post_id}/patch" :put
             {:path-params   {"post_id" post-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-45
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn posts-post-id-patch-put
  "Patch a post
  Partially update a post by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.
##### Permissions
Must have the `edit_post` permission."
  ([post-id ] (posts-post-id-patch-put post-id nil))
  ([post-id optional-params]
   (:data (posts-post-id-patch-put-with-http-info post-id optional-params))))

(defn posts-post-id-pin-post-with-http-info
  "Pin a post to the channel
  Pin a post to a channel it is in based from the provided post id string.
##### Permissions
Must be authenticated and have the `read_channel` permission to the channel the post is in."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}/pin" :post
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-pin-post
  "Pin a post to the channel
  Pin a post to a channel it is in based from the provided post id string.
##### Permissions
Must be authenticated and have the `read_channel` permission to the channel the post is in."
  [post-id ]
  (:data (posts-post-id-pin-post-with-http-info post-id)))

(defn posts-post-id-put-with-http-info
  "Update a post
  Update a post. Only the fields listed below are updatable, omitted fields will be treated as blank.
##### Permissions
Must have `edit_post` permission for the channel the post is in."
  ([post-id ] (posts-post-id-put-with-http-info post-id nil))
  ([post-id {:keys [inline-object-44 ]}]
   (check-required-params post-id)
   (call-api "/posts/{post_id}" :put
             {:path-params   {"post_id" post-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-44
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn posts-post-id-put
  "Update a post
  Update a post. Only the fields listed below are updatable, omitted fields will be treated as blank.
##### Permissions
Must have `edit_post` permission for the channel the post is in."
  ([post-id ] (posts-post-id-put post-id nil))
  ([post-id optional-params]
   (:data (posts-post-id-put-with-http-info post-id optional-params))))

(defn posts-post-id-thread-get-with-http-info
  "Get a thread
  Get a post and the rest of the posts in the same thread.
##### Permissions
Must have `read_channel` permission for the channel the post is in or if the channel is public, have the `read_public_channels` permission for the team."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}/thread" :get
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-thread-get
  "Get a thread
  Get a post and the rest of the posts in the same thread.
##### Permissions
Must have `read_channel` permission for the channel the post is in or if the channel is public, have the `read_public_channels` permission for the team."
  [post-id ]
  (:data (posts-post-id-thread-get-with-http-info post-id)))

(defn posts-post-id-unpin-post-with-http-info
  "Unpin a post to the channel
  Unpin a post to a channel it is in based from the provided post id string.
##### Permissions
Must be authenticated and have the `read_channel` permission to the channel the post is in."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}/unpin" :post
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-unpin-post
  "Unpin a post to the channel
  Unpin a post to a channel it is in based from the provided post id string.
##### Permissions
Must be authenticated and have the `read_channel` permission to the channel the post is in."
  [post-id ]
  (:data (posts-post-id-unpin-post-with-http-info post-id)))

(defn teams-team-id-posts-search-post-with-http-info
  "Search for team posts
  Search posts in the team and from the provided terms string.
##### Permissions
Must be authenticated and have the `view_team` permission."
  ([team-id ] (teams-team-id-posts-search-post-with-http-info team-id nil))
  ([team-id {:keys [inline-object-46 ]}]
   (check-required-params team-id)
   (call-api "/teams/{team_id}/posts/search" :post
             {:path-params   {"team_id" team-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-46
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn teams-team-id-posts-search-post
  "Search for team posts
  Search posts in the team and from the provided terms string.
##### Permissions
Must be authenticated and have the `view_team` permission."
  ([team-id ] (teams-team-id-posts-search-post team-id nil))
  ([team-id optional-params]
   (:data (teams-team-id-posts-search-post-with-http-info team-id optional-params))))

(defn user-user-id-posts-post-id-set-unread-post-with-http-info
  "Mark as unread from a post.
  Mark a channel as being unread from a given post.
##### Permissions
Must have `read_channel` permission for the channel the post is in or if the channel is public, have the `read_public_channels` permission for the team.
Must have `edit_other_users` permission if the user is not the one marking the post for himself.

__Minimum server version__: 5.18"
  [user-id post-id ]
  (check-required-params user-id post-id)
  (call-api "/user/{user_id}/posts/{post_id}/set_unread" :post
            {:path-params   {"user_id" user-id "post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn user-user-id-posts-post-id-set-unread-post
  "Mark as unread from a post.
  Mark a channel as being unread from a given post.
##### Permissions
Must have `read_channel` permission for the channel the post is in or if the channel is public, have the `read_public_channels` permission for the team.
Must have `edit_other_users` permission if the user is not the one marking the post for himself.

__Minimum server version__: 5.18"
  [user-id post-id ]
  (:data (user-user-id-posts-post-id-set-unread-post-with-http-info user-id post-id)))

(defn users-user-id-channels-channel-id-posts-unread-get-with-http-info
  "Get posts around last unread
  Get the oldest unread post in the channel for the given user as well as the posts around it.
##### Permissions
Must be logged in as the user or have `edit_other_users` permission, and must have `read_channel` permission for the channel.
__Minimum server version__: 5.14"
  ([user-id channel-id ] (users-user-id-channels-channel-id-posts-unread-get-with-http-info user-id channel-id nil))
  ([user-id channel-id {:keys [limit-before limit-after ]}]
   (check-required-params user-id channel-id)
   (call-api "/users/{user_id}/channels/{channel_id}/posts/unread" :get
             {:path-params   {"user_id" user-id "channel_id" channel-id }
              :header-params {}
              :query-params  {"limit_before" limit-before "limit_after" limit-after }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-channels-channel-id-posts-unread-get
  "Get posts around last unread
  Get the oldest unread post in the channel for the given user as well as the posts around it.
##### Permissions
Must be logged in as the user or have `edit_other_users` permission, and must have `read_channel` permission for the channel.
__Minimum server version__: 5.14"
  ([user-id channel-id ] (users-user-id-channels-channel-id-posts-unread-get user-id channel-id nil))
  ([user-id channel-id optional-params]
   (:data (users-user-id-channels-channel-id-posts-unread-get-with-http-info user-id channel-id optional-params))))

(defn users-user-id-posts-flagged-get-with-http-info
  "Get a list of flagged posts
  Get a page of flagged posts of a user provided user id string. Selects from a channel, team or all flagged posts by a user.
##### Permissions
Must be user or have `manage_system` permission."
  ([user-id ] (users-user-id-posts-flagged-get-with-http-info user-id nil))
  ([user-id {:keys [team-id channel-id page per-page ]}]
   (check-required-params user-id)
   (call-api "/users/{user_id}/posts/flagged" :get
             {:path-params   {"user_id" user-id }
              :header-params {}
              :query-params  {"team_id" team-id "channel_id" channel-id "page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn users-user-id-posts-flagged-get
  "Get a list of flagged posts
  Get a page of flagged posts of a user provided user id string. Selects from a channel, team or all flagged posts by a user.
##### Permissions
Must be user or have `manage_system` permission."
  ([user-id ] (users-user-id-posts-flagged-get user-id nil))
  ([user-id optional-params]
   (:data (users-user-id-posts-flagged-get-with-http-info user-id optional-params))))

