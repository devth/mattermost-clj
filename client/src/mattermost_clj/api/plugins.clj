(ns mattermost-clj.api.plugins
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn plugins-get-with-http-info
  "Get plugins
  Get a list of inactive and a list of active plugin manifests. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  []
  (call-api "/plugins" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn plugins-get
  "Get plugins
  Get a list of inactive and a list of active plugin manifests. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  []
  (:data (plugins-get-with-http-info)))

(defn plugins-install-from-url-post-with-http-info
  "Install plugin from url
  Supply a URL to a plugin compressed in a .tar.gz file. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.14"
  ([plugin-download-url ] (plugins-install-from-url-post-with-http-info plugin-download-url nil))
  ([plugin-download-url {:keys [force ]}]
   (check-required-params plugin-download-url)
   (call-api "/plugins/install_from_url" :post
             {:path-params   {}
              :header-params {}
              :query-params  {"plugin_download_url" plugin-download-url "force" force }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn plugins-install-from-url-post
  "Install plugin from url
  Supply a URL to a plugin compressed in a .tar.gz file. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 5.14"
  ([plugin-download-url ] (plugins-install-from-url-post plugin-download-url nil))
  ([plugin-download-url optional-params]
   (:data (plugins-install-from-url-post-with-http-info plugin-download-url optional-params))))

(defn plugins-plugin-id-delete-with-http-info
  "Remove plugin
  Remove the plugin with the provided ID from the server. All plugin files are deleted. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  [plugin-id ]
  (check-required-params plugin-id)
  (call-api "/plugins/{plugin_id}" :delete
            {:path-params   {"plugin_id" plugin-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn plugins-plugin-id-delete
  "Remove plugin
  Remove the plugin with the provided ID from the server. All plugin files are deleted. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  [plugin-id ]
  (:data (plugins-plugin-id-delete-with-http-info plugin-id)))

(defn plugins-plugin-id-disable-post-with-http-info
  "Disable plugin
  Disable a previously enabled plugin. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  [plugin-id ]
  (check-required-params plugin-id)
  (call-api "/plugins/{plugin_id}/disable" :post
            {:path-params   {"plugin_id" plugin-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn plugins-plugin-id-disable-post
  "Disable plugin
  Disable a previously enabled plugin. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  [plugin-id ]
  (:data (plugins-plugin-id-disable-post-with-http-info plugin-id)))

(defn plugins-plugin-id-enable-post-with-http-info
  "Enable plugin
  Enable a previously uploaded plugin. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  [plugin-id ]
  (check-required-params plugin-id)
  (call-api "/plugins/{plugin_id}/enable" :post
            {:path-params   {"plugin_id" plugin-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn plugins-plugin-id-enable-post
  "Enable plugin
  Enable a previously uploaded plugin. Plugins must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  [plugin-id ]
  (:data (plugins-plugin-id-enable-post-with-http-info plugin-id)))

(defn plugins-post-with-http-info
  "Upload plugin
  Upload a plugin that is contained within a compressed .tar.gz file. Plugins and plugin uploads must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  ([^File plugin ] (plugins-post-with-http-info plugin nil))
  ([^File plugin {:keys [force ]}]
   (check-required-params plugin)
   (call-api "/plugins" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {"plugin" plugin "force" force }
              :content-types ["multipart/form-data"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn plugins-post
  "Upload plugin
  Upload a plugin that is contained within a compressed .tar.gz file. Plugins and plugin uploads must be enabled in the server's config settings.

##### Permissions
Must have `manage_system` permission.

__Minimum server version__: 4.4"
  ([^File plugin ] (plugins-post plugin nil))
  ([^File plugin optional-params]
   (:data (plugins-post-with-http-info plugin optional-params))))

(defn plugins-webapp-get-with-http-info
  "Get webapp plugins
  Get a list of web app plugins installed and activated on the server.

##### Permissions
No permissions required.

__Minimum server version__: 4.4"
  []
  (call-api "/plugins/webapp" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn plugins-webapp-get
  "Get webapp plugins
  Get a list of web app plugins installed and activated on the server.

##### Permissions
No permissions required.

__Minimum server version__: 4.4"
  []
  (:data (plugins-webapp-get-with-http-info)))

