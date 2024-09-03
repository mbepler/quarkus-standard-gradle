#!/bin/bash

cd "$(dirname "$0")" || exit
docker compose -f compose.yaml up
