(ns mattermost-clj.api.jobs
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn jobs-get-with-http-info
  "Get the jobs.
  Get a page of jobs. Use the query parameters to modify the behaviour of this endpoint.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  ([] (jobs-get-with-http-info nil))
  ([{:keys [page per-page ]}]
   (call-api "/jobs" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn jobs-get
  "Get the jobs.
  Get a page of jobs. Use the query parameters to modify the behaviour of this endpoint.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  ([] (jobs-get nil))
  ([optional-params]
   (:data (jobs-get-with-http-info optional-params))))

(defn jobs-job-id-cancel-post-with-http-info
  "Cancel a job.
  Cancel a job.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  [job-id ]
  (check-required-params job-id)
  (call-api "/jobs/{job_id}/cancel" :post
            {:path-params   {"job_id" job-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn jobs-job-id-cancel-post
  "Cancel a job.
  Cancel a job.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  [job-id ]
  (:data (jobs-job-id-cancel-post-with-http-info job-id)))

(defn jobs-job-id-get-with-http-info
  "Get a job.
  Gets a single job.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  [job-id ]
  (check-required-params job-id)
  (call-api "/jobs/{job_id}" :get
            {:path-params   {"job_id" job-id }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types []
             :accepts       ["application/json"]
             :auth-names    []}))

(defn jobs-job-id-get
  "Get a job.
  Gets a single job.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  [job-id ]
  (:data (jobs-job-id-get-with-http-info job-id)))

(defn jobs-post-with-http-info
  "Create a new job.
  Create a new job.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  ([] (jobs-post-with-http-info nil))
  ([{:keys [inline-object-47 ]}]
   (call-api "/jobs" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-47
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn jobs-post
  "Create a new job.
  Create a new job.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  ([] (jobs-post nil))
  ([optional-params]
   (:data (jobs-post-with-http-info optional-params))))

(defn jobs-type-type-get-with-http-info
  "Get the jobs of the given type.
  Get a page of jobs of the given type. Use the query parameters to modify the behaviour of this endpoint.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  ([type ] (jobs-type-type-get-with-http-info type nil))
  ([type {:keys [page per-page ]}]
   (check-required-params type)
   (call-api "/jobs/type/{type}" :get
             {:path-params   {"type" type }
              :header-params {}
              :query-params  {"page" page "per_page" per-page }
              :form-params   {}
              :content-types []
              :accepts       ["application/json"]
              :auth-names    []})))

(defn jobs-type-type-get
  "Get the jobs of the given type.
  Get a page of jobs of the given type. Use the query parameters to modify the behaviour of this endpoint.
__Minimum server version: 4.1__
##### Permissions
Must have `manage_jobs` permission."
  ([type ] (jobs-type-type-get type nil))
  ([type optional-params]
   (:data (jobs-type-type-get-with-http-info type optional-params))))

