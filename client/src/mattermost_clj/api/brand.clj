(ns mattermost-clj.api.brand
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn brand-image-delete-with-http-info
  "Delete current brand image
  Deletes the previously uploaded brand image. Returns 404 if no brand image has been uploaded.
##### Permissions
Must have `manage_system` permission.
__Minimum server version: 5.6__"
  []
  (call-api "/brand/image" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn brand-image-delete
  "Delete current brand image
  Deletes the previously uploaded brand image. Returns 404 if no brand image has been uploaded.
##### Permissions
Must have `manage_system` permission.
__Minimum server version: 5.6__"
  []
  (:data (brand-image-delete-with-http-info)))

(defn brand-image-get-with-http-info
  "Get brand image
  Get the previously uploaded brand image. Returns 404 if no brand image has been uploaded.
##### Permissions
No permission required."
  []
  (call-api "/brand/image" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn brand-image-get
  "Get brand image
  Get the previously uploaded brand image. Returns 404 if no brand image has been uploaded.
##### Permissions
No permission required."
  []
  (:data (brand-image-get-with-http-info)))

(defn brand-image-post-with-http-info
  "Upload brand image
  Uploads a brand image.
##### Permissions
Must have `manage_system` permission."
  [^File image ]
  (check-required-params image)
  (call-api "/brand/image" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"image" image }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn brand-image-post
  "Upload brand image
  Uploads a brand image.
##### Permissions
Must have `manage_system` permission."
  [^File image ]
  (:data (brand-image-post-with-http-info image)))

