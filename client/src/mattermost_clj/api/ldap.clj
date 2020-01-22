(ns mattermost-clj.api.ldap
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn ldap-sync-post-with-http-info
  "Sync with LDAP
  Synchronize any user attribute changes in the configured AD/LDAP server with Mattermost.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/ldap/sync" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn ldap-sync-post
  "Sync with LDAP
  Synchronize any user attribute changes in the configured AD/LDAP server with Mattermost.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (ldap-sync-post-with-http-info)))

(defn ldap-test-post-with-http-info
  "Test LDAP configuration
  Test the current AD/LDAP configuration to see if the AD/LDAP server can be contacted successfully.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/ldap/test" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn ldap-test-post
  "Test LDAP configuration
  Test the current AD/LDAP configuration to see if the AD/LDAP server can be contacted successfully.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (ldap-test-post-with-http-info)))

