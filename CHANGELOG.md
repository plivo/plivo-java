# Change Log

## [5.3.0](https://github.com/plivo/plivo-java/tree/v5.3.0) (2021-07-20)
- This version includes advancements to the Messaging Interface that deals with the [Send SMS/MMS](https://www.plivo.com/docs/sms/api/message#send-a-message) interface, Creating a standard structure for `request/input` arguments to make implementation easier and incorporating support for the older interface.

## [5.2.0](https://github.com/plivo/plivo-java/tree/v5.2.0) (2021-07-15)
- Added SDK support for MPC APIs (Voice retry included for APIs) and XML

## [5.1.0](https://github.com/plivo/plivo-java/tree/v5.1.0) (2021-07-14)
- Powerpack UUID has been included to the response for the [list all messages API](https://www.plivo.com/docs/sms/api/message/list-all-messages/) and the [get message details API](https://www.plivo.com/docs/sms/api/message#retrieve-a-message).
- Support for filtering messages by Powerpack UUID has been added to the [list all messages API](https://www.plivo.com/docs/sms/api/message#list-all-messages).

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
