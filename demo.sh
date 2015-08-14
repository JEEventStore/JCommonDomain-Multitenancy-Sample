#!/bin/sh

BASE=http://localhost:8080/jcommondomain-multitenancy-sample/api

curl -w "\n" -H "Accept: application/json" $BASE/product/CUST1/sku-1
curl -w "\n" -H "Accept: application/json" $BASE/product/CUST2/sku-1
curl -w "\n" -D - -X PUT -H "Accept: application/json" -H "Content-Type: application/json" -d '{"name":"Product 1", "price":123.45}' $BASE/product/CUST1/sku-1

curl -w "\n" -H "Accept: application/json" $BASE/product/CUST1/sku-1
curl -w "\n" -H "Accept: application/json" $BASE/product/CUST2/sku-1
