lol4j
=====

League of Legends Riot Games API Java wrapper

Example Usage
-------------
```java

Lol4JClient client = new Lol4JClientImpl("apiKey");

System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
System.out.println("CHAMPION RESOURCE");
System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
ChampionListDto championList = client.getChampionResource().getAllChampions("na", true);
for (ChampionDto champ : championList.getChampions()) {
    System.out.println(champ.getName());
}

System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
System.out.println("GAME RESOURCE");
System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
RecentGamesDto recentGames = client.getGameResource().getRecentGames("na", summonerId);
for (GameDto game : recentGames.getGames()) {
    System.out.println(getChampionById(game.getChampionId(), championList).getName());
}

System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
System.out.println("LEAGUE RESOURCE");
System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
Map<String, LeagueDto> leaguesData = client.getLeagueResource().getLeaguesData("na", summonerId);
for (Map.Entry<String, LeagueDto> entry : leaguesData.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue().getName());
}
```

lol4j isn’t endorsed by Riot Games and doesn’t reflect the views or opinions of Riot Games or anyone officially involved in producing or managing League of Legends. League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.