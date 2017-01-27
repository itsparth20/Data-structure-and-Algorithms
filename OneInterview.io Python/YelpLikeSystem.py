import random
import sys
import os
import cmath

'''
Build a simple Yelp-like system: Given a set of restaurant and metadata (coordinates, ratings, opening hours), design and implement the following functionalities without using a database.

1. Find restaurants within specified radius, given a coordinate
2. Improve the above function by only returning restaurants that are open given desired dining hour
3. Improve the above function by sorting the results by average ratings
'''

class Yelp(object):

    def __init__(self, restaurants, ratings):
        self.restaurants = restaurants
        self.ratings = ratings

    def find(self, coordinates, radius, dining_hour=None, sort_by_rating=False):
        lati = coordinates[0]
        long = coordinates[1]
        restaurant = {}

        dis = 0;
        for x in self.restaurants:
            dis = (((lati-x.latitude)**2)+((long-x.longitude)**2))*0.5
            dis = dis/1000

            if dis <= radius:
                for y in self.ratings:
                    if(x.id == y.restaurant_id):
                        if dining_hour != None:
                            if ((dining_hour >= x.open_hour) and (dining_hour <= x.close_hour)):
                                resName = x.name
                                rat = y.rating
                                restaurant[resName] = rat
                        else:
                            resName = x.name
                            rat = y.rating
                            restaurant[resName] = rat
                        break
        if sort_by_rating == True:
            sortedByreat = sorted(restaurant.items(), key=lambda t: t[1], reverse=True)
            print(sortedByreat)
            return sortedByreat

        print(restaurant)
        # Returns list of Restaurant within radius.
        #
        #  coordinates: (latitude, longitude)
        #  radius: kilometer in integer
        #  dining_hour: If None, find any restaurant in radius.
        #               Otherwise return list of open restaurants at specified hour.
        #  sort_by_rating: If True, sort result in descending order,
        #                  highest rated first.
        return restaurant

class Restaurant(object):
    # where open_hour and close_hour is in [0-23]
    def __init__(self, id, name, latitude, longitude, open_hour, close_hour):
        self.id = id
        self.name = name
        self.latitude = latitude
        self.longitude = longitude
        self.open_hour = open_hour
        self.close_hour = close_hour

class Rating(object):
    # rating is in [1-5]
    def __init__(self, restaurant_id, rating):
        self.restaurant_id = restaurant_id
        self.rating = rating


restaurants = [Restaurant(0, "Domino's Pizza", 37.7577, -122.4376, 7, 23), Restaurant(1, "Domino's Pizza1", 37.7577, -122.4376, 23, 23)]
ratings = [Rating(0, 3),Rating(1, 5)]

y = Yelp(restaurants, ratings)
y.find((37.7, -120.6), 5, 23, True)

