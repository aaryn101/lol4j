lol4j
=====

lol4j is a Java wrapper for the Riot Games LoL beta API. It is easy to use and provides the developer with complete
access to all of the resources provided by Riot. lol4j is very fast and handles all of the JSON unmarshalling so
devs only work with Plain Old Java Objects.

Gradle is used to handle dependencies and orchestrate the build process. To run JUnit tests through Gradle, create a
junit.properties file in the root of the project.

Example Usage
-------------
```java

Lol4JClient client = new Lol4JClientImpl("apiKey");

ChampionListDto championList = client.getAllChampions(Region.NA, true);
RecentGamesDto recentGames = client.getRecentGames(19163557, Region.NA);
Map<String, LeagueDto> leaguesData = client.getLeaguesData(19163557, Region.NA);
PlayerStatsSummaryListDto playerStatsSummaries = client.getPlayerStatsSummaries(19163557, Region.NA, Season.SEASON_3);
RankedStatsDto rankedStats = client.getRankedStats(19163557, Region.NA, Season.SEASON_3);
MasteryPagesDto masteryPages = client.getMasteryPages(19163557, Region.NA);
```

Rate Limiting
-------------

A rate limiter is built in to lol4j. Enabling it is as simple as the following:
```java

Lol4JClient client = new Lol4JClientImpl("apiKey");
client.setRateLimit(numPerTenSeconds, numPerTenMinutes);
```
For example, if you have a developer API key with the default rate limit, you'd make the following call:
```java

client.setRateLimit(10, 500);
```
lol4j uses true rate limiting - rather than restrict you to X requests per second, lol4j allows you to harness the full
power of the Riot API. lol4j doesn't ignore the "burstiness" that Riot allows - do you need to make 10 requests right
away? No problem! lol4j handles all of the hard work for you, ensuring that you don't get errors by making more than X
requests per 10 seconds and Y requests per 10 minutes.

Rate limiting, if it is going to be used, should be enabled before any requests are made.

Legalese
--------
lol4j isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved
in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of
Riot Games, Inc. League of Legends © Riot Games, Inc.