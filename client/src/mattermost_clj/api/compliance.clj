(ns mattermost-clj.api.compliance
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn compliance-reports-get-with-http-info
  "Get reports
  Get a list of compliance reports previously created by page, selected with `page` and `per_page` query parameters.
##### Permissions
Must have `manage_system` permission."
  ([] (compliance-reports-get-with-http-info nil))
  ([{:keys [page per-page ]}]
   (call-api "/compliance/reports" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn compliance-reports-get
  "Get reports
  Get a list of compliance reports previously created by page, selected with `page` and `per_page` query parameters.
##### Permissions
Must have `manage_system` permission."
  ([] (compliance-reports-get nil))
  ([optional-params]
   (:data (compliance-reports-get-with-http-info optional-params))))

(defn compliance-reports-post-with-http-info
  "Create report
  Create and save a compliance report.
##### Permissions
Must have `manage_system` permission."
  []
  (call-api "/compliance/reports" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn compliance-reports-post
  "Create report
  Create and save a compliance report.
##### Permissions
Must have `manage_system` permission."
  []
  (:data (compliance-reports-post-with-http-info)))

(defn compliance-reports-report-id-download-get-with-http-info
  "Download a report
  Download the full contents of a report as a file.
##### Permissions
Must have `manage_system` permission."
  [report-id ]
  (check-required-params report-id)
  (call-api "/compliance/reports/{report_id}/download" :get
            {:path-params   {"report_id" report-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn compliance-reports-report-id-download-get
  "Download a report
  Download the full contents of a report as a file.
##### Permissions
Must have `manage_system` permission."
  [report-id ]
  (:data (compliance-reports-report-id-download-get-with-http-info report-id)))

(defn compliance-reports-report-id-get-with-http-info
  "Get a report
  Get a compliance reports previously created.
##### Permissions
Must have `manage_system` permission."
  [report-id ]
  (check-required-params report-id)
  (call-api "/compliance/reports/{report_id}" :get
            {:path-params   {"report_id" report-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn compliance-reports-report-id-get
  "Get a report
  Get a compliance reports previously created.
##### Permissions
Must have `manage_system` permission."
  [report-id ]
  (:data (compliance-reports-report-id-get-with-http-info report-id)))

