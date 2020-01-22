(ns mattermost-clj.api.integration-actions
  (:require [mattermost-clj.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn actions-dialogs-open-post-with-http-info
  "Open a dialog
  Open an interactive dialog using a trigger ID provided by a slash command, or some other action payload. See https://docs.mattermost.com/developer/interactive-dialogs.html for more information on interactive dialogs.
__Minimum server version: 5.6__"
  ([] (actions-dialogs-open-post-with-http-info nil))
  ([{:keys [inline-object-66 ]}]
   (call-api "/actions/dialogs/open" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-66
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn actions-dialogs-open-post
  "Open a dialog
  Open an interactive dialog using a trigger ID provided by a slash command, or some other action payload. See https://docs.mattermost.com/developer/interactive-dialogs.html for more information on interactive dialogs.
__Minimum server version: 5.6__"
  ([] (actions-dialogs-open-post nil))
  ([optional-params]
   (:data (actions-dialogs-open-post-with-http-info optional-params))))

(defn actions-dialogs-submit-post-with-http-info
  "Submit a dialog
  Endpoint used by the Mattermost clients to submit a dialog. See https://docs.mattermost.com/developer/interactive-dialogs.html for more information on interactive dialogs.
__Minimum server version: 5.6__"
  ([] (actions-dialogs-submit-post-with-http-info nil))
  ([{:keys [inline-object-67 ]}]
   (call-api "/actions/dialogs/submit" :post
             {:path-params   {}
              :header-params {}
              :query-params  {}
              :form-params   {}
              :body-param    inline-object-67
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    []})))

(defn actions-dialogs-submit-post
  "Submit a dialog
  Endpoint used by the Mattermost clients to submit a dialog. See https://docs.mattermost.com/developer/interactive-dialogs.html for more information on interactive dialogs.
__Minimum server version: 5.6__"
  ([] (actions-dialogs-submit-post nil))
  ([optional-params]
   (:data (actions-dialogs-submit-post-with-http-info optional-params))))

