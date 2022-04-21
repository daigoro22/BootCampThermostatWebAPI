#!/bin/sh

URL="$1api/v1/temperature"
YEAR=`shuf -i 2000-2022 -n 1`
MONTH=`shuf -i 01-12 -n 1`
DAY=`shuf -i 01-31 -n 1`
DEGREE=`shuf -i 0-50 -n 1`
LNG=`shuf -i 0-180 -n 1`
LAT=`shuf -i 0-180 -n 1`

DATE=`date "+%Y-%m-%dT%H:%M:%S"`

curl -X 'POST' \
  $URL \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "timestamp": "'$DATE'",
  "degree": '$DEGREE',
  "degreeType": "Celsius",
  "longitude": '$LNG',
  "latitude": '$LAT' 
}'
