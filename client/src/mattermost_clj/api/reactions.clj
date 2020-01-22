(ns mattermost-clj.api.reactions
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn posts-ids-reactions-post-with-http-info
  "Bulk get the reaction for posts
  Get a list of reactions made by all users to a given post.
##### Permissions
Must have `read_channel` permission for the channel the post is in.

__Minimum server version__: 5.8"
  [string ]
  (check-required-params string)
  (call-api "/posts/ids/reactions" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-ids-reactions-post
  "Bulk get the reaction for posts
  Get a list of reactions made by all users to a given post.
##### Permissions
Must have `read_channel` permission for the channel the post is in.

__Minimum server version__: 5.8"
  [string ]
  (:data (posts-ids-reactions-post-with-http-info string)))

(defn posts-post-id-reactions-get-with-http-info
  "Get a list of reactions to a post
  Get a list of reactions made by all users to a given post.
##### Permissions
Must have `read_channel` permission for the channel the post is in."
  [post-id ]
  (check-required-params post-id)
  (call-api "/posts/{post_id}/reactions" :get
            {:path-params   {"post_id" post-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn posts-post-id-reactions-get
  "Get a list of reactions to a post
  Get a list of reactions made by all users to a given post.
##### Permissions
Must have `read_channel` permission for the channel the post is in."
  [post-id ]
  (:data (posts-post-id-reactions-get-with-http-info post-id)))

(defn reactions-post-with-http-info
  "Create a reaction
  Create a reaction.
##### Permissions
Must have `read_channel` permission for the channel the post is in."
  [reaction ]
  (check-required-params reaction)
  (call-api "/reactions" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    reaction
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn reactions-post
  "Create a reaction
  Create a reaction.
##### Permissions
Must have `read_channel` permission for the channel the post is in."
  [reaction ]
  (:data (reactions-post-with-http-info reaction)))

(defn users-user-id-posts-post-id-reactions-emoji-name-delete-with-http-info
  "Remove a reaction from a post
  Deletes a reaction made by a user from the given post.
##### Permissions
Must be user or have `manage_system` permission."
  [user-id post-id emoji-name ]
  (check-required-params user-id post-id emoji-name)
  (call-api "/users/{user_id}/posts/{post_id}/reactions/{emoji_name}" :delete
            {:path-params   {"user_id" user-id "post_id" post-id "emoji_name" emoji-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn users-user-id-posts-post-id-reactions-emoji-name-delete
  "Remove a reaction from a post
  Deletes a reaction made by a user from the given post.
##### Permissions
Must be user or have `manage_system` permission."
  [user-id post-id emoji-name ]
  (:data (users-user-id-posts-post-id-reactions-emoji-name-delete-with-http-info user-id post-id emoji-name)))

