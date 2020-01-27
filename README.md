# mattermost-clj

This is a generated [Mattermost API](https://api.mattermost.com/) client. It
uses [Mattermost's OpenAPI
specification](https://api.mattermost.com/static/mattermost-openapi-v4.yaml) and
the [openapi-generator](https://github.com/OpenAPITools/openapi-generator) tool.

## Coordinates

```clojure
[mattermost-clj "4.0.0"]
```

## Usage

```clojure
(require '[mattermost-clj.core :as mattermost])

(def my-token "xxxyyyzzz")

(def host "my-mattermost-instance.herokuapp.com")

(mattermost/set-api-context
   {:debug true
    :base-url (str "https://" host "/api/v4")
    :auths {"api_key" (str "Bearer " token)}})

;; try calling an API
(require '[mattermost-clj.api.teams :as teams])

(teams/teams-get-with-http-info)
```

## Dev

### Prerequisites

```bash
brew install openapi-generator
```

## Explore the `openapi-generator` CLI

```bash
openapi-generator help
openapi-generator help generate
openapi-generator config-help -g clojure
```

### Obtain OpenAPI spec

Obtain a fresh copy of the spec and commit this to the repo to keep it in sync
with generated source:

```bash
curl -o openapi.yaml https://api.mattermost.com/static/mattermost-openapi-v4.yaml
```

Note: use openapi-generator 3.x. 4.x generates buggy Clojure specs that break
the generated client.

To install 3.3.0:

```bash
brew install https://raw.githubusercontent.com/Homebrew/homebrew-core/53d1f029cb5694a41640cff05a3791e5ffac37c6/Formula/openapi-generator.rb
```

### Generate the client

The spec contains a few validation errors, so we need to skip validation with
`--skip-validate-spec` in order to generate.

```bash

openapi-generator generate \
    --skip-validate-spec \
    -i openapi.yaml -c gen-config.json -g clojure -o client
```

Know validation errors are:

```
Semantic error at paths./posts/{post_id}/patch.put.parameters.1.schema.properties.file_ids
Schemas with 'type: array', require a sibling 'items: ' field
Line 6546

Structural error at paths./system/ping.get.responses.500
should NOT have additional properties
additionalProperty: schema
Line 7564

Structural error at paths./brand/image.get.responses.404
should NOT have additional properties
additionalProperty: description
Line 9910

Structural error at paths./brand/image.delete.responses.404
should NOT have additional properties
additionalProperty: description
Line 9995
```

Manually patched openapi.yaml to fix these. Follow along on [the GitHub
issue](https://github.com/mattermost/mattermost-api-reference/issues/468) which
recommends fixes.

- Manually patched to include auth in calls via:

  ```
  :auth-names    ["api_key"]
  ```

  Note: only `teams`, `bots`, and `posts` namespaces have been patched

**We can't regenerate the client at this point since so many manual patches
needed to be applied.**

### Install client locally

```bash
cd client && lein install; cd ..
```

### Deploy to Clojars

```bash
cd client && lein deploy; cd ..
```
