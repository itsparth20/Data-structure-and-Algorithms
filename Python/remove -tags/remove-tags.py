#!/usr/bin/python
import argparse
import requests
import json
import threading
import csv
import random
from time import sleep,time
from kafka import KafkaProducer
from kafka.errors import KafkaError

post_category_url = ''
get_tags_url = ''
post_tag_url = ''
delete_tag_url = ''
get_groundtruthpath_url = ''
tag_prefix = "6854f5"
sleep_duration = 1.0
locationTopic = 'tagPosition'
current_milli_time = lambda: int(round(time() * 1000))

def main():
    #Parse the arguments
    args = parse_args()
    args.headers = {'Authorization':'enl {}:{}'.format(args.api_key,args.security_token),'Content-Type':'application/json;charset=UTF-8'}
    print(args.kafka_brokers.split(','))
    args.producer = KafkaProducer(value_serializer=lambda m: json.dumps(m), bootstrap_servers=args.kafka_brokers.split(','))

    #Get/Create the simulated_objects category
    args.category = 'Simulated_Objects'
    get_category(args)

    #Get/Create the simulated object tags
    get_tags(args)

def get_tags(args):
    url = get_tags_url.format(args.where_host,args.organization,args.category_id)
    response = requests.get(url, headers=args.headers, verify=False)
    data = response.json()
    print(data)
    #Create list of tags required
    tag_id_list = []
    for i in range(0,int(args.tag_count)):
        hex_str = hex(int(args.tag_id, 16) + i)
        hex_str = hex_str[2:].zfill(6)
        tag_id_list.append(hex_str)

    print(tag_id_list)
    #Get/Create the missing tags
    for tag_id in tag_id_list:
        for tag in data['data']:	
            if tag['serialNumber'] == tag_prefix + tag_id:
                print(tag)
                url = delete_tag_url.format(args.where_host, tag['gid'])
                response = requests.delete(url, headers=args.headers, verify=False)
                print(response)
                break
    args.tag_id_list = tag_id_list

def get_category(args):
    url = 'https://{}/where/organization/{}/categories?filter=category/name eq \'{}\''.format(args.where_host,args.organization,args.category)
    response = requests.get(url, headers=args.headers, verify=False)
    data = response.json()
    print(data)
    if len(data['data']) == 0:
        print('Category ' + args.category + ' doesn\'t exist. Creating...')
        url = 'https://{}/where/organization/{}/categories?filter=category/parent eq empty and category/name eq \'Objects\''.format(args.where_host,args.organization)
        response = requests.get(url, headers=args.headers, verify=False)
        data = response.json()
        print(data)
        if len(data['data']) == 0:
            failure('Objects category not found',1)

        category = {"type":"asset","name":args.category,"email":"noreply@enlightedinc.com","parent":data['data'][0]['gid'],"org":args.organization}
        url = post_category_url.format(args.where_host)
        response = requests.post(url, data = json.dumps(category), headers=args.headers, verify=False)
        data = response.json()
        args.category_id = data['gid']
        print(data)
    else:
        args.category_id = data['data'][0]['gid']


def parse_args():
    parser = argparse.ArgumentParser(description='Script for Where data collection')
    parser.add_argument('where_host',
                        help='Host name/IP')
    parser.add_argument('kafka_brokers',
                        help='Kafka brokers list')
    parser.add_argument('api_key',
                        help='Where API key')
    parser.add_argument('security_token',
                        help='Where API security token')
    parser.add_argument('organization',
                        help='Organization GID')
    parser.add_argument('floor',
                        help='Floor GID')
    parser.add_argument('ground_truth_path_list',
                    help='Ground truth path list (comma separated)')
    parser.add_argument('tag_id',
                    help='Tag ID')
    parser.add_argument('tag_count',
                    help='Number of tags to simulate')
    return parser.parse_args()

def failure(error_code, error_message):
    sys.stderr.write("\nFAILURE : " + error_message+"\n\n")
    sys.exit(error_code)

if __name__ == "__main__":
    main()
