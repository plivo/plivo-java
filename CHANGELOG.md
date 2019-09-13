# Change Log

## [4.4.3](https://github.com/plivo/plivo-java/tree/v4.4.2) (2019-09-13)
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
