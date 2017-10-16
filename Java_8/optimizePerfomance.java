 //new solution
            utilizationMap.entrySet().stream().forEach(kv -> {
                GroupingKey groupKey = kv.getKey();
                if(lim == Integer.MAX_VALUE ||groupKey.getKeys().stream().anyMatch( p -> groups.contains(p.getRight()))){
                	if (groupedUtilizationMap.containsKey(groupKey)) 
                        groupedUtilizationMap.get(groupKey).combineWith(kv.getValue());
                     else 
                    	groupedUtilizationMap.put(groupKey, kv.getValue());
                }
                else{
                	groupKey.setKeys(groupKey.getKeys().stream()
                            .map(p -> Pair.of(p.getLeft(), "other"))
                            .collect(Collectors.toList()));
                	if (groupedUtilizationMap.containsKey(groupKey)) 
                        groupedUtilizationMap.get(groupKey).combineWith(kv.getValue());
                    else
                        groupedUtilizationMap.put(groupKey, kv.getValue());
                } 
            });

/*            utilizationMap = utilizationMap.entrySet()
                    .stream()
                    .sorted((kv1, kv2) -> {
                        return kv1.getValue().result() > kv2.getValue().result() ? -1 :
                                kv1.getValue().result() < kv2.getValue().result() ? 1 : 0;
                    }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            utilizationMap.entrySet().stream().limit(lim).forEach(kv -> {
                GroupingKey groupKey = kv.getKey();
                groupKey.setKeys(groupKey.getKeys().stream()
                        .collect(Collectors.toList()));
                if (groupedUtilizationMap.containsKey(groupKey)) {
                    groupedUtilizationMap.get(groupKey).combineWith(kv.getValue());
                } else {
                    groupedUtilizationMap.put(groupKey, kv.getValue());
                }
            });

            utilizationMap.entrySet().stream().skip(lim).forEach(kv -> {
                GroupingKey groupKey = kv.getKey();
                groupKey.setKeys(groupKey.getKeys().stream()
                            .map(p -> Pair.of(p.getLeft(), "other"))
                            .collect(Collectors.toList()));
                if (groupedUtilizationMap.containsKey(groupKey)) {
                    groupedUtilizationMap.get(groupKey).combineWith(kv.getValue());
                } else {
                    groupedUtilizationMap.put(groupKey, kv.getValue());
                }
            });*/