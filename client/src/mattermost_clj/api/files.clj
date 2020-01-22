(ns mattermost-clj.api.files
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn files-file-id-get-with-http-info
  "Get a file
  Gets a file that has been uploaded previously.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (check-required-params file-id)
  (call-api "/files/{file_id}" :get
            {:path-params   {"file_id" file-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn files-file-id-get
  "Get a file
  Gets a file that has been uploaded previously.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (:data (files-file-id-get-with-http-info file-id)))

(defn files-file-id-info-get-with-http-info
  "Get metadata for a file
  Gets a file's info.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (check-required-params file-id)
  (call-api "/files/{file_id}/info" :get
            {:path-params   {"file_id" file-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn files-file-id-info-get
  "Get metadata for a file
  Gets a file's info.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (:data (files-file-id-info-get-with-http-info file-id)))

(defn files-file-id-link-get-with-http-info
  "Get a public file link
  Gets a public link for a file that can be accessed without logging into Mattermost.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (check-required-params file-id)
  (call-api "/files/{file_id}/link" :get
            {:path-params   {"file_id" file-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn files-file-id-link-get
  "Get a public file link
  Gets a public link for a file that can be accessed without logging into Mattermost.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (:data (files-file-id-link-get-with-http-info file-id)))

(defn files-file-id-preview-get-with-http-info
  "Get a file's preview
  Gets a file's preview.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (check-required-params file-id)
  (call-api "/files/{file_id}/preview" :get
            {:path-params   {"file_id" file-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn files-file-id-preview-get
  "Get a file's preview
  Gets a file's preview.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (:data (files-file-id-preview-get-with-http-info file-id)))

(defn files-file-id-thumbnail-get-with-http-info
  "Get a file's thumbnail
  Gets a file's thumbnail.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (check-required-params file-id)
  (call-api "/files/{file_id}/thumbnail" :get
            {:path-params   {"file_id" file-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn files-file-id-thumbnail-get
  "Get a file's thumbnail
  Gets a file's thumbnail.
##### Permissions
Must have `read_channel` permission or be uploader of the file."
  [file-id ]
  (:data (files-file-id-thumbnail-get-with-http-info file-id)))

(defn files-post-with-http-info
  "Upload a file
  Uploads a file that can later be attached to a post.

This request can either be a multipart/form-data request with a channel_id, files and optional
client_ids defined in the FormData, or it can be a request with the channel_id and filename
defined as query parameters with the contents of a single file in the body of the request.

Only multipart/form-data requests are supported by server versions up to and including 4.7.
Server versions 4.8 and higher support both types of requests.

##### Permissions
Must have `upload_file` permission."
  ([] (files-post-with-http-info nil))
  ([{:keys [channel-id filename ^File files channel-id client-ids ]}]
   (call-api "/files" :post
             {:path-params   {}
              :header-params {}
              :query-params  {"channel_id" channel-id "filename" filename }
              :form-params   {"files" files "channel_id" channel-id "client_ids" client-ids }
              :content-types ["multipart/form-data" ]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn files-post
  "Upload a file
  Uploads a file that can later be attached to a post.

This request can either be a multipart/form-data request with a channel_id, files and optional
client_ids defined in the FormData, or it can be a request with the channel_id and filename
defined as query parameters with the contents of a single file in the body of the request.

Only multipart/form-data requests are supported by server versions up to and including 4.7.
Server versions 4.8 and higher support both types of requests.

##### Permissions
Must have `upload_file` permission."
  ([] (files-post nil))
  ([optional-params]
   (:data (files-post-with-http-info optional-params))))

