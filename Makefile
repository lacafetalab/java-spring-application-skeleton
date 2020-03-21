.DEFAULT_GOAL := help

## GENERAL ##
OWNER 			= utp
SERVICE_NAME 	= gamma
PATH_PREFIX 	= "/v1"

## DEPLOY ##
ENV 			?= dev
version 		?= 1.0.0.1

## RESULT_VARS ##
export PROJECT_NAME	= $(OWNER)-$(SERVICE_NAME)

## Target Commons ##

test: ## build image to dev: make build
	@./gradlew test --warning-mode all

build-app: ## build image to dev: make build
	@./gradlew build --warning-mode all

run: ## build image to dev: make build
	@./gradlew :run

## Target Help ##

help:
	@printf "\033[31m%-16s %-59s %s\033[0m\n" "Target" "Help" "Usage"; \
	printf "\033[31m%-16s %-59s %s\033[0m\n" "------" "----" "-----"; \
	grep -hE '^\S+:.*## .*$$' $(MAKEFILE_LIST) | sed -e 's/:.*##\s*/:/' | sort | awk 'BEGIN {FS = ":"}; {printf "\033[32m%-16s\033[0m %-58s \033[34m%s\033[0m\n", $$1, $$2, $$3}'
