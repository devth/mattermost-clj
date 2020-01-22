(ns mattermost-clj.api.saml
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn saml-certificate-idp-delete-with-http-info
  "Remove IDP certificate
  Delete the current IDP certificate being used with your SAML configuration. This will also disable SAML on your system as this certificate is required for SAML.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/saml/certificate/idp" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-idp-delete
  "Remove IDP certificate
  Delete the current IDP certificate being used with your SAML configuration. This will also disable SAML on your system as this certificate is required for SAML.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (saml-certificate-idp-delete-with-http-info)))

(defn saml-certificate-idp-post-with-http-info
  "Upload IDP certificate
  Upload the IDP certificate to be used with your SAML configuration. The server will pick a hard-coded filename for the IdpCertificateFile setting in your `config.json`.
##### Permissions
Must have `manage_system` permission."
  [^File certificate ]
  (check-required-params certificate)
  (call-api "/saml/certificate/idp" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"certificate" certificate }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-idp-post
  "Upload IDP certificate
  Upload the IDP certificate to be used with your SAML configuration. The server will pick a hard-coded filename for the IdpCertificateFile setting in your `config.json`.
##### Permissions
Must have `manage_system` permission."
  [^File certificate ]
  (:data (saml-certificate-idp-post-with-http-info certificate)))

(defn saml-certificate-private-delete-with-http-info
  "Remove private key
  Delete the current private key being used with your SAML configuration. This will also disable encryption for SAML on your system as this key is required for that.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/saml/certificate/private" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-private-delete
  "Remove private key
  Delete the current private key being used with your SAML configuration. This will also disable encryption for SAML on your system as this key is required for that.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (saml-certificate-private-delete-with-http-info)))

(defn saml-certificate-private-post-with-http-info
  "Upload private key
  Upload the private key to be used for encryption with your SAML configuration. The server will pick a hard-coded filename for the PrivateKeyFile setting in your `config.json`.
##### Permissions
Must have `manage_system` permission."
  [^File certificate ]
  (check-required-params certificate)
  (call-api "/saml/certificate/private" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"certificate" certificate }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-private-post
  "Upload private key
  Upload the private key to be used for encryption with your SAML configuration. The server will pick a hard-coded filename for the PrivateKeyFile setting in your `config.json`.
##### Permissions
Must have `manage_system` permission."
  [^File certificate ]
  (:data (saml-certificate-private-post-with-http-info certificate)))

(defn saml-certificate-public-delete-with-http-info
  "Remove public certificate
  Delete the current public certificate being used with your SAML configuration. This will also disable encryption for SAML on your system as this certificate is required for that.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/saml/certificate/public" :delete
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-public-delete
  "Remove public certificate
  Delete the current public certificate being used with your SAML configuration. This will also disable encryption for SAML on your system as this certificate is required for that.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (saml-certificate-public-delete-with-http-info)))

(defn saml-certificate-public-post-with-http-info
  "Upload public certificate
  Upload the public certificate to be used for encryption with your SAML configuration. The server will pick a hard-coded filename for the PublicCertificateFile setting in your `config.json`.
##### Permissions
Must have `manage_system` permission."
  [^File certificate ]
  (check-required-params certificate)
  (call-api "/saml/certificate/public" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {"certificate" certificate }
             :content-types ["multipart/form-data"]
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-public-post
  "Upload public certificate
  Upload the public certificate to be used for encryption with your SAML configuration. The server will pick a hard-coded filename for the PublicCertificateFile setting in your `config.json`.
##### Permissions
Must have `manage_system` permission."
  [^File certificate ]
  (:data (saml-certificate-public-post-with-http-info certificate)))

(defn saml-certificate-status-get-with-http-info
  "Get certificate status
  Get the status of the uploaded certificates and keys in use by your SAML configuration.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/saml/certificate/status" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-certificate-status-get
  "Get certificate status
  Get the status of the uploaded certificates and keys in use by your SAML configuration.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (saml-certificate-status-get-with-http-info)))

(defn saml-metadata-get-with-http-info
  "Get metadata
  Get SAML metadata from the server. SAML must be configured properly.
##### Permissions
No permission required."
  []
  (call-api "/saml/metadata" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn saml-metadata-get
  "Get metadata
  Get SAML metadata from the server. SAML must be configured properly.
##### Permissions
No permission required."
  []
  (:data (saml-metadata-get-with-http-info)))

