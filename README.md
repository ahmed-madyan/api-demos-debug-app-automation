Browser Stack integration steps

Sample request for uploading the App with custom ID
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X POST "https://api-cloud.browserstack.com/app-automate/upload" -F "file=@C:\Users\_VOIS\Documents\GitHub\rahul-appium-automation\ApiDemos-debug.apk" -F "custom_id=CyberSafetyApp"

Sample response
{"app_url":"bs://f1c40ad07ef1f65b37c5536fed97a28d204255e5","custom_id":"CyberSafetyApp","shareable_id":"ahmedmadyan_oxTGNa/CyberSafetyApp"}

Sample request for deleting the App
curl -u "ahmedmadyan_oxTGNa:efFbRGj4yaxcVuPxyJKs" -X DELETE "https://api-cloud.browserstack.com/app-automate/app/delete/1824c7990fe34023bdd4e19715f15873e71ea265"