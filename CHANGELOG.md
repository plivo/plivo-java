# Change Log

## [5.40.0](https://github.com/plivo/plivo-java/tree/v5.40.0) (2023-04-12)
**Feature - Support for dynamic payload in whatsapp templates**
- Added new params `payload` in templates to support dynamic payload in templates

## [5.39.0](https://github.com/plivo/plivo-java/tree/v5.39.0) (2024-03-13)
**Feature - Import Campaign API**
- Import Campaign API


## [5.38.3](https://github.com/plivo/plivo-java/tree/v5.38.3) (2024-02-28)
**Feature - Log Redaction Enhancement**
-  Added log attribute in GET and List MDR response
-  Change log field from bool to string in send SMS 

## [5.38.2](https://github.com/plivo/plivo-java/tree/v5.38.2) (2024-01-15)
**Feature - Made meta object consistent for List Powerpacks, List Media, List Numbers, List Shortcodes, List Tollfree API**
- Made meta object consistent in API response

## [5.38.1](https://github.com/plivo/plivo-java/tree/v5.38.1) (2023-12-19)
**Feature - Added params for Speak API**
- Added params 'type' for Speak APIs

## [5.38.0](https://github.com/plivo/plivo-java/tree/v5.38.0) (2023-11-30)
**Feature - Added params for GET and LIST Campaign API**
- Added params 'vertical', 'campaign_alias' for GET and LIST Campaign APIs

## [5.37.0](https://github.com/plivo/plivo-java/tree/v5.37.0) (2023-11-29)
**Feature - add new response fields for LIST and GET campaign**
- Added new response params `error_code`, `error_reason` for LIST / GET Campaign APIs

## [5.36.0](https://github.com/plivo/plivo-java/tree/v5.36.0) (2023-11-09)
**Feature - registration_status field**
- Added new param `registration_status` in LIST Campaign APIs


## [5.35.0](https://github.com/plivo/plivo-java/tree/v5.35.0) (2023-11-08)
**Verify Service**
-Added Support for Verify Service Public API'S 
-Create Session API(POST): To create a verify session (2FA). Allowed params recipient, method, channel, callback_url, app_uuid
-Get Session API(GET): To retrieve a particular session
-List Sessions : To retrieve all the sessions
-Validate Session : To validate OTP for a particular session
## [5.34.0](https://github.com/plivo/plivo-java/tree/v5.34.0) (2023-11-03)
**Feature - TollFree Verification API Support**
- API support for Create, Update, Get, Delete and List Tollfree Verification.
- Added New Param `toll_free_sms_verification_id` and `toll_free_sms_verification_order_status `in to the response of the [list all numbers API], [list single number API]
- Added `toll_free_sms_verification_order_status` filter to AccountPhoneNumber - list all my numbers API.

## [5.33.0](https://github.com/plivo/plivo-java/tree/v5.33.0) (2023-10-20)
**Feature - campaign_source field**
- Added new param `campaign_source` in LIST / GET Campaign APIs

## [5.32.0](https://github.com/plivo/plivo-java/tree/v5.32.0) (2023-10-18)
**Feature - Verify Caller Id API support**
- API support for verifying, updating, getting and deleting caller IDs.

## [5.31.1](https://github.com/plivo/plivo-java/tree/v5.31.1) (2023-10-05)
**Feature - WhatsApp message support**
- Version bump

## [5.31.0](https://github.com/plivo/plivo-java/tree/v5.31.0) (2023-10-05)
**Feature - WhatsApp message support**
- Added new params `template`, `template_json_string` and new message_type `whatsapp` to [send message API](https://www.plivo.com/docs/sms/api/message#send-a-message)
- Added  new  `message_states` (`read`), `message_type`(`whatsapp`), `conversation_id`, `conversation_origin`, `conversation_expiry_timestamp` in [list all messages API](https://www.plivo.com/docs/sms/api/message#list-all-messages) and [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message) response


## [5.30.0](https://github.com/plivo/plivo-java/tree/v5.30.0) (2023-08-25)
**Feature - Added New Param 'carrier_fees', 'carrier_fees_rate', 'destination_network' in Get Message and List Message APIs**
- Added new params on message get and list response

## [5.29.0](https://github.com/plivo/plivo-java/tree/v5.29.0) (2023-08-03)
**Feature - DLT parameters**
- Added new params `DLTEntityID`, `DLTTemplateID`, `DLTTemplateCategory` to the [send message API](https://www.plivo.com/docs/sms/api/message/send-a-message/)
- Added new params `DLTEntityID`, `DLTTemplateID`, `DLTTemplateCategory` to the response for the [list all messages API](https://www.plivo.com/docs/sms/api/message/list-all-messages/) and the [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message)

## [5.28.0](https://github.com/plivo/plivo-java/tree/v5.28.0) (2023-06-28)
**Feature - Stream API and XML support**
- API support for starting, deleting, getting streams on a live call
- XML creation support for stream element

## [5.27.0](https://github.com/plivo/plivo-java/tree/v5.27.0) (2023-05-02)
**Feature - CNAM Lookup**
- Added New Param `cnam_lookup` in to the response of the [list all numbers API], [list single number API]
- Added `cnam_lookup` filter to AccountPhoneNumber - list all my numbers API.
- Added `cnam_lookup` parameter to buy number[Buy a Phone Number]  to configure CNAM Lookup while buying a US number
- Added `cnam_lookup` parameter to update number[Update an account phone number] to configure CNAM Lookup while buying a US number

## [5.26.0](https://github.com/plivo/plivo-java/tree/v5.26.0) (2023-06-01)
**Feature - Added New Param 'cnam_lookup_number_config' in GetCall and ListCalls**
- Add `cnam_lookup_number_config` to the response for the [retrieve a call details API](https://www.plivo.com/docs/voice/api/call#retrieve-a-call) and the [retreive all call details API](https://www.plivo.com/docs/voice/api/call#retrieve-all-calls)

## [5.25.0](https://github.com/plivo/plivo-java/tree/v5.25.0) (2023-05-29)
- Added `monthly_recording_storage_amount`, `recording_storage_rate`, `rounded_recording_duration`, and `recording_storage_duration` parameters to the response for [get single recording API](https://www.plivo.com/docs/voice/api/recording#retrieve-a-recording) and [get all recordings API](https://www.plivo.com/docs/voice/api/recording#list-all-recordings)
- Added `recording_storage_duration` parameter as a filter option for [get all recordings API](https://www.plivo.com/docs/voice/api/recording#list-all-recordings)

## [5.24.0](https://github.com/plivo/plivo-java/tree/v5.24.0) (2023-05-04)
- Add New Param `renewalDate` to the response of the [list all numbers API], [list single number API]
- Add 5 new filters to AccountPhoneNumber - list all my numbers API:`renewal_date`, `renewal_date__gt`, `renewal_date__gte`,`renewal_date__lt` and `renewal_date__lte` (https://www.plivo.com/docs/numbers/api/account-phone-number#list-all-my-numbers)

## [5.23.0](https://github.com/plivo/plivo-java/tree/v5.23.0) (2023-04-25)
- Add `replacedSender` to the response for the [list all messages API](https://www.plivo.com/docs/sms/api/message/list-all-messages/) and the [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message)

## [5.22.1](https://github.com/plivo/plivo-java/tree/v5.22.1) (2023-02-23)
**Removed unwanted files from the repo **

## [5.22.0](https://github.com/plivo/plivo-dotnet/tree/v5.22.0) (2023-04-11)
**Feature - Added New Param 'source_ip' in GetCall and ListCalls**
- Add `source_ip` to the response for the [retrieve a call details API](https://www.plivo.com/docs/voice/api/call#retrieve-a-call) and the [retreive all call details API](https://www.plivo.com/docs/voice/api/call#retrieve-all-calls)
 
## [5.21.0](https://github.com/plivo/plivo-java/tree/v5.21.0) (2023-17-03)
- Added New Param `created_at` to the response for the [list all profiles API](https://www.plivo.com/docs/sms/api/10dlc/profile#retrieve-all-profiles) and the [get profile API](https://www.plivo.com/docs/sms/api/10dlc/profile#retrieve-a-specific-profile) and the [list all brands API](https://www.plivo.com/docs/sms/api/10dlc/brand#retrieve-all-brands) and the [get brand API](https://www.plivo.com/docs/sms/api/10dlc/brand#retrieve-a-specific-brand)
and the [list all campaigns API](https://www.plivo.com/docs/sms/api/10dlc/campaign#retrieve-all-campaigns) and the [get campaign API](https://www.plivo.com/docs/sms/api/10dlc/campaign#retrieve-a-specific-campaign)

## [5.20.0](https://github.com/plivo/plivo-java/tree/v5.20.0) (2023-02-23)
- Add `isDomestic` to the response for the [list all messages API](https://www.plivo.com/docs/sms/api/message/list-all-messages/) and the [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message)

## [5.19.2](https://github.com/plivo/plivo-java/tree/v5.19.2) (2023-02-23)
**Feature - Enhance MDR filtering capabilities **
- Added new fields on MDR object response

## [5.19.1](https://github.com/plivo/plivo-java/tree/v5.19.1) (2022-01-31)
- Add `requesterIP` to the response for the [list all messages API](https://www.plivo.com/docs/sms/api/message/list-all-messages/) and the [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message)

## [5.18.0](https://github.com/plivo/plivo-java/tree/v5.18.0) (2022-01-23)
**Feature - Update Campaign API**
- Update Campaign API

## [5.17.0](https://github.com/plivo/plivo-java/tree/v5.17.0) (2023-01-18)
**Feature - Add new param(Message Expiry) in Send Message API**
- Added new param(Message Expiry) in Send Message API

## [5.16.0](https://github.com/plivo/plivo-java/tree/v5.16.0) (2022-12-06)
**Feature - Delete Campaign and Brand**
- Delete Campaign and Brand API Endpoints

## [5.15.1](https://github.com/plivo/plivo-java/tree/v5.15.1) (2022-11-04)
**Adding - BrandUsecase API api contract refactor**
- BrandUsecase API contract refactor

## [5.15.0](https://github.com/plivo/plivo-java/tree/v5.15.0) (2022-10-17)
**Feature - BrandUsecase API, 10DLC API Enhancement**
- BrandUsecase API, 10DLC API Enhancement

## [5.14.0](https://github.com/plivo/plivo-java/tree/v5.14.0) (2022-10-14)
**Adding new attributes to Account PhoneNumber object**
-Added 3 new keys to AccountPhoneNumber object:`tendlc_registration_status`, `tendlc_campaign_id` and `toll_free_sms_verification` (https://www.plivo.com/docs/numbers/api/account-phone-number#the-accountphonenumber-object)
-Added 3 new filters to AccountPhoneNumber - list all my numbers API:`tendlc_registration_status`, `tendlc_campaign_id` and `toll_free_sms_verification` (https://www.plivo.com/docs/numbers/api/account-phone-number#list-all-my-numbers)

## [5.13.2](https://github.com/plivo/plivo-java/tree/v5.13.2) (2022-10-12)
**Bug fix on number response**
-MMSEnabled and MMSRate fix on list of all rented numbers,Single rented number,Search number

## [5.13.1](https://github.com/plivo/plivo-java/tree/v5.13.1) (2022-09-28)
**Adding more Attributes to campaign creation as optional params**
-Adding more Attributes to campaign creation as optional params

## [5.13.0](https://github.com/plivo/plivo-java/tree/v5.13.0) (2022-09-01)
**Feature - 10DLC API Support**
- New 10DLC API Support

## [5.12.0](https://github.com/plivo/plivo-java/tree/v5.12.0) (2022-08-08)
**Feature - Token Creation**
- `JWT Token Creation API` added API to create a new JWT token.

## [5.11.0](https://github.com/plivo/plivo-java/tree/v5.11.0) (2022-05-05)
**Feature - List all recordings**
- `fromNumber` and `toNumber` added to filtering param [List all recordings](https://www.plivo.com/docs/voice/api/recording#list-all-recordings)
- `recordMinMemberCount` param added in [Add a participant to a multiparty call using API](https://www.plivo.com/docs/voice/api/multiparty-call/participants#add-a-participant)

## [5.10.0](https://github.com/plivo/plivo-java/tree/v5.10.0) (2022-03-25)
**Feature - DialElement**
- `confirmTimeout` parameter added to [The Dial element](https://www.plivo.com/docs/voice/xml/dial/)

## [5.9.3](https://github.com/plivo/plivo-java/tree/v5.9.3) (2022-03-08)
**Bug fix** 
- Remove unnecessary log lines.

## [5.9.2](https://github.com/plivo/plivo-java/tree/v5.9.2) (2022-02-22)
**ResponseFix - memberAddressAdded**

## [5.9.1](https://github.com/plivo/plivo-java/tree/v5.9.1) (2022-02-04)
**BugFix - MessageCreate**
- Source and Destination number validation

## [5.9.0](https://github.com/plivo/plivo-java/tree/v5.9.0) (2022-02-02)
**Features - MPCCallRecording**
- Parameter change from statusCall to recordingCallback

## [5.8.0](https://github.com/plivo/plivo-java/tree/v5.8.0) (2022-01-05)
**Features - Generic**
- Default log level set to 'NONE'
- Enabled log level to be configurable from customers end

## [5.7.0](https://github.com/plivo/plivo-java/tree/v5.7.0) (2021-12-16)
**Features - SMS**
- 10dlc api support

## [5.6.0](https://github.com/plivo/plivo-java/tree/v5.6.0) (2021-12-14)
**Features - Voice**
- Routing SDK traffic through Akamai endpoints for all the [Voice APIs](https://www.plivo.com/docs/voice/api/overview/)

## [5.5.0](https://github.com/plivo/plivo-java/tree/v5.5.0) (2021-11-25)
**Features - Voice: Multiparty calls**
- The [Add Multiparty Call API](https://www.plivo.com/docs/voice/api/multiparty-call/participants#add-a-participant) allows for greater functionality by accepting options like `start recording audio`, `stop recording audio`, and their HTTP methods.
- [Multiparty Calls](https://www.plivo.com/docs/voice/api/multiparty-call/) now has new APIs to `stop` and `play` audio.

## [5.4.1](https://github.com/plivo/plivo-java/tree/v5.4.1) (2021-11-05)
**Bug Fix**
- [Update Powerpack API](https://www.plivo.com/docs/sms/api/powerpack#update-a-powerpack) response to retrun `number_pool` parameter.

## [5.4.0](https://github.com/plivo/plivo-java/tree/v5.4.0) (2021-10-22)
**Features - Messaging**
- This version includes advancements to the Messaging Interface that deals with the [Send SMS/MMS](https://www.plivo.com/docs/sms/api/message#send-a-message) interface, Creating a standard structure for `request/input` arguments to make implementation easier and incorporating support for the older interface.
 
 Example for [send SMS](https://github.com/plivo/plivo-java#send-a-message)

## [5.3.1](https://github.com/plivo/plivo-java/tree/v5.3.1) (2021-08-26)
- Bug fix on delete methods and powerpack response fix.

## [5.3.0](https://github.com/plivo/plivo-java/tree/v5.3.0) (2021-08-04)
- Add setter methods for voice,language,loop params in Speak Xml element.

## [5.2.1](https://github.com/plivo/plivo-java/tree/v5.2.1) (2021-07-23)
- Update default request timeout value to 5 seconds.

## [5.2.0](https://github.com/plivo/plivo-java/tree/v5.2.0) (2021-07-15)
- Add SDK support for MPC APIs (Voice retry included for APIs) and XML

## [5.1.0](https://github.com/plivo/plivo-java/tree/v5.1.0) (2021-07-14)
- Add Powerpack UUID to the response for the [list all messages API](https://www.plivo.com/docs/sms/api/message/list-all-messages/) and the [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message).
- Add support for filtering messages by Powerpack UUID has been added to the [list all messages API](https://www.plivo.com/docs/sms/api/message#list-all-messages).

## [5.0.0](https://github.com/plivo/plivo-java/tree/v5.0.0) (2021-07-05)
- **BREAKING**: Remove getTotalCount() method for list MDR.

## [4.15.3](https://github.com/plivo/plivo-java/tree/v4.15.3) (2021-07-05)
- **WARNING**: Remove total_count field from meta data for list MDR response. getTotalCount() for list MDR will return 0.

## [4.15.2](https://github.com/plivo/plivo-java/tree/v4.15.2) (2021-06-07)
- Adds VoiceNetworkGroup to List/Get Call response.

## [4.15.1](https://github.com/plivo/plivo-java/tree/v4.15.1) (2021-04-22)
- Bug Fix for adaptive powerpack feature.

## [4.15.0](https://github.com/plivo/plivo-java/tree/v4.15.0) (2021-02-09)
- Add XML support JDK 11.

## [4.14.0](https://github.com/plivo/plivo-java/tree/v4.14.0) (2020-11-17)
- Add number_priority support for Powerpack API.

## [4.13.0](https://github.com/plivo/plivo-java/tree/v4.13.0) (2020-11-05)
- Add Regulatory Compliance API support.

## [4.12.0](https://github.com/plivo/plivo-java/tree/v4.12.0) (2020-10-30)
- Change lookup API endpoint and response.

## [4.11.1](https://github.com/plivo/plivo-java/tree/v4.11.1) (2020-10-13)
- Add ConferenceUuid & CallState for Get Details of a Call API.

## [4.11.0](https://github.com/plivo/plivo-java/tree/v4.11.0) (2020-10-06)
- Add Lookup API support.

## [4.10.0](https://github.com/plivo/plivo-java/tree/v4.10.0) (2020-09-25)
- Add "publicUri" optional param support for Application API.

## [4.9.0](https://github.com/plivo/plivo-java/tree/v4.9.0) (2020-09-04)
- Add Powerpack for MMS.

## [4.8.0](https://github.com/plivo/plivo-java/tree/v4.8.0) (2020-08-24)
- Add retries to multiple regions for voice requests.

## [4.7.3](https://github.com/plivo/plivo-java/tree/v4.7.3) (2020-08-03)
- Fix Media upload response.

## [4.7.2](https://github.com/plivo/plivo-java/tree/v4.7.2) (2020-06-10)
- Fix Record a Call API by adding optional params.

## [4.7.1](https://github.com/plivo/plivo-java/tree/v4.7.1) (2020-05-15)
- Fix Get Number details API response.

## [4.7.0](https://github.com/plivo/plivo-java/tree/v4.7.0) (2020-05-11)
- Add JWT helper functions.

## [4.6.0](https://github.com/plivo/plivo-java/tree/v4.6.0) (2020-04-29)
- Add V3 signature helper functions.

## [4.5.0](https://github.com/plivo/plivo-java/tree/v4.5.0) (2020-01-29)
- Add application cascade delete support.
- Add post call quality feedback API support.
- Add Tollfree support for Powerpack
- Add Media support.
- Add MMS and Powerpack support.

## [4.4.4](https://github.com/plivo/plivo-java/tree/v4.4.4) (2019-11-19)
- Add GetInput XML support

## [4.4.3](https://github.com/plivo/plivo-java/tree/v4.4.3) (2019-11-06)
- Add SSML support

## [4.4.2](https://github.com/plivo/plivo-java/tree/v4.4.2) (2019-09-16)
- Fix Record a Call API

## [4.4.1](https://github.com/plivo/plivo-java/tree/v4.4.1) (2019-04-12)
- Add PHLO Run getter

## [4.4.0](https://github.com/plivo/plivo-java/tree/v4.4.0) (2019-03-28)
- Add PHLO support
- Add Multi-Party Call triggers

## [4.1.6](https://github.com/plivo/plivo-java/tree/v4.1.6) (2018-11-21)
- Add sub-account cascade delete support.

## [4.3.0-beta-2](https://github.com/plivo/plivo-java/tree/v4.3.0-beta-2) (2018-11-13)
- Fixed Phlo response support.

## [4.3.0-beta-1](https://github.com/plivo/plivo-java/tree/v4.3.0-beta-1) (2018-11-03)
- Add support for filtering live calls by from number, to number and call direction.
- Add hangup party details in get CDR. Add filtering by hangup source and hangup cause code.

## [4.2.0-beta-3](https://github.com/plivo/plivo-java/tree/v4.2.0-beta-3) (2018-10-29)
- Phlo params support
- Phlo and node level execution revamp

## [4.2.0-beta-2](https://github.com/plivo/plivo-java/tree/v4.2.0-beta-2) (2018-10-24)
- Beta release of Phlo
- Live calls filtering

## [4.1.5](https://github.com/plivo/plivo-java/tree/v4.1.5) (2018-11-08)
- fixed the field lookup for hangup source, hangup cause name and hangup cause code in call retrieval.

## [4.1.4](https://github.com/plivo/plivo-java/tree/v4.1.4) (2018-10-23)
- Add support for filtering live calls by from number, to number and call direction.
- Add hangup party details in get CDR. Add filtering by hangup source and hangup cause code.

## [4.2.0-alpha-1](https://github.com/plivo/plivo-java/tree/v4.2.0-alpha-1) (2018-09-05)
- Add Phlo Support. Releasing in Alpha.

## [4.1.3](https://github.com/plivo/plivo-java/tree/v4.1.3) (2018-08-21)
- Add support for fetching queued_call details
- Add powerpack support
- Add Log Incoming Message in resources

## [4.1.0](https://github.com/plivo/plivo-java/tree/v4.1.0) (2018-08-21)
- Added api's for address and identity verification

## [4.0.4](https://github.com/plivo/plivo-java/tree/v4.0.4) (2018-08-15)
- Fixed asynchronous outbound call

## [4.0.3](https://github.com/plivo/plivo-java/tree/v4.0.3) (2018-07-27)
- Add gradle task `fatJar` to create fat jar.
- Fix gradle task `javadocJar`.

## [4.0.2](https://github.com/plivo/plivo-java/tree/v4.0.2) (2018-04-25)
- Fix validate Signature. Supporting URL with Port.
- Add .create(), .get(), .delete(), and other actions to Resource.client(client).
- Add call_state parameter to Call resource.
- Add test classes for DTMF send digits.
- Upgrade gradle to fix travis build.
- Add Examples.

## [4.0.1](https://github.com/plivo/plivo-java/tree/v4.0.1) (2018-02-20)
- Fix #38. The SDK now supports using Subaccounts to make API calls.

## [4.0.0](https://github.com/plivo/plivo-java/tree/v4.0.0) (2018-01-18)
- No changes since Beta 3. Releasing in GA.

## [4.0.0-beta-3](https://github.com/plivo/plivo-java/tree/v4.0.0-beta-3) (2017-11-10)
- Fix #31.
- Support X-Plivo-Signature-V2. Dropped support for V1 signature.

## 4.0.0-beta-2 (2017-10-30)
- Exactly same as 4.0.0-beta-1. As good as a yanked version. No release tag.
- Removed default POM.xml while publishing to Sonatype.
- Available on MavenCentral along with 4.0.0-beta-1.

## [4.0.0-beta-1](https://github.com/plivo/plivo-java/tree/v4.0.0-beta-1) (2017-10-30)
- The new SDK works with both Java 1.8 & 1.9 (JDKs 8 & 9)
- The API interfaces are consistent and guessable
- Handles pagination automatically when listing all objects of a resource

## Other changes
2016-06-02 Added digitsMatchBLeg parameter to Dial XML
2013-10-25 Added stopSpeak()
2013-09-03 Fixed issue with unicode values assigned to API parameters.
