(ns mattermost-clj.api.roles
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn roles-name-role-name-get-with-http-info
  "Get a role
  Get a role from the provided role name.

##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 4.9"
  [role-name ]
  (check-required-params role-name)
  (call-api "/roles/name/{role_name}" :get
            {:path-params   {"role_name" role-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn roles-name-role-name-get
  "Get a role
  Get a role from the provided role name.

##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 4.9"
  [role-name ]
  (:data (roles-name-role-name-get-with-http-info role-name)))

(defn roles-names-post-with-http-info
  "Get a list of roles by name
  Get a list of roles from their names.

##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 4.9"
  [string ]
  (check-required-params string)
  (call-api "/roles/names" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    string
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn roles-names-post
  "Get a list of roles by name
  Get a list of roles from their names.

##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 4.9"
  [string ]
  (:data (roles-names-post-with-http-info string)))

(defn roles-role-id-get-with-http-info
  "Get a role
  Get a role from the provided role id.

##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 4.9"
  [role-id ]
  (check-required-params role-id)
  (call-api "/roles/{role_id}" :get
            {:path-params   {"role_id" role-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn roles-role-id-get
  "Get a role
  Get a role from the provided role id.

##### Permissions
Requires an active session but no other permissions.

__Minimum server version__: 4.9"
  [role-id ]
  (:data (roles-role-id-get-with-http-info role-id)))

(defn roles-role-id-patch-put-with-http-info
  "Patch a role
  Partially update a role by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 4.9"
  ([role-id ] (roles-role-id-patch-put-with-http-info role-id nil))
  ([role-id {:keys [inline-object-62 ]}]
   (check-required-params role-id)
   (call-api "/roles/{role_id}/patch" :put
             {:path-params   {"role_id" role-id }
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-62
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn roles-role-id-patch-put
  "Patch a role
  Partially update a role by providing only the fields you want to update. Omitted fields will not be updated. The fields that can be updated are defined in the request body, all other provided fields will be ignored.

##### Permissions
`manage_system` permission is required.

__Minimum server version__: 4.9"
  ([role-id ] (roles-role-id-patch-put role-id nil))
  ([role-id optional-params]
   (:data (roles-role-id-patch-put-with-http-info role-id optional-params))))

