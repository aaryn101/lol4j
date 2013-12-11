lol4j
=====

League of Legends Riot Games API Java wrapper

Example Usage
-------------
```java

Lol4JClient client = new Lol4JClientImpl("apiKey", "http://prod.api.pvp.net/api/lol");

System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
System.out.println("CHAMPION RESOURCE");
System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
ChampionListDto championList = client.getChampionResource().getAllChampions("na", false);
for (ChampionDto champ : championList.getChampions()) {
    System.out.println(champ.getName());
}

System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
System.out.println("GAME RESOURCE");
System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
RecentGamesDto recentGames = client.getGameResource().getRecentGames("na", 19163557);
for (GameDto game : recentGames.getGames()) {
    System.out.println(getChampionById(game.getChampionId(), championList).getName());
}
```