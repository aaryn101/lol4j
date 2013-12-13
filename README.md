lol4j
=====

lol4j is a Java wrapper for the Riot Games LoL beta API. It is easy to use and provides the developer with easy access
to all of the resources provided by Riot. lol4j is very fast and will handle all of the JSON unmarshalling so
developers only work with Plain Old Java Objects.

Example Usage
-------------
```java

Lol4JClient client = new Lol4JClientImpl("apiKey");

ChampionListDto championList = client.getAllChampions(Region.NA, true);
RecentGamesDto recentGames = client.getRecentGames(Region.NA, 19163557);
Map<String, LeagueDto> leaguesData = client.getLeaguesData(Region.NA, 19163557);
PlayerStatsSummaryListDto playerStatsSummaries = client.getPlayerStatsSummaries(Region.NA, 19163557, Season.SEASON_3);
RankedStatsDto rankedStats = client.getRankedStats(Region.NA, 19163557, Season.SEASON_3);
MasteryPagesDto masteryPages = client.getMasteryPages(Region.NA, 19163557);
```

lol4j isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved
in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of
Riot Games, Inc. League of Legends © Riot Games, Inc.