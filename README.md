Browser Stack integration steps

Sample request for uploading the App with custom ID
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\Users\_VOIS\Documents\Mobile Applications\Android\ApiDemos-debug.apk" -F "custom_id=ApiDemosDebugApk"

Sample response
{"app_url":"bs://429a51d7bdc18eda26260c79f7338fc98357370b","custom_id":"ApiDemosDebugApk","shareable_id":"ahmedmadyan_oxTGNa/ApiDemosDebugApk"}

Sample request for deleting the App
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X DELETE "https://api-cloud.browserstack.com/app-automate/app/delete/429a51d7bdc18eda26260c79f7338fc98357370b"