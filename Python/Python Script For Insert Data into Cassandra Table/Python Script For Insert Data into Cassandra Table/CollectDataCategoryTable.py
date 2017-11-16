import uuid

from cassandra import ConsistencyLevel
from cassandra import InvalidRequest
from cassandra.cluster import Cluster
from cassandra.query import SimpleStatement

KEYSPACE = "where_data"

def createTag(session, org, type, uuidList, tagName):
	i = 0
	for parentId in uuidList:
		i += 1
		id = str(uuid.uuid1())
		name = tagName + str(i)
		createLevel(session, org, type, id, name, parentId)
		
		id = str(uuid.uuid1())
		i += 1
		name = tagName + str(i)
		createLevel(session, org, type, id, name, parentId)
		 

def createCategory(session, org, type, name, parent, uuidList):
	for i in range(125):
		id = str(uuid.uuid1())
		categoryName = name + "-"+ str(i+1)
		createLevel(session, org, type, id, categoryName, parent)
		uuidList.append(id)

def createRoot(session, org, idPeople, name, type):
	session.execute("insert into category(id,org,name,type,tagcount,deleted,lostMotionIntervalSeconds,lastUpdated,createdBy,datecreated) values("+ idPeople +","+ org +",'"+ name +"','"+ type +"',0,false,0,1502394093118,'AANhcGkABmdsb2JhbLaImADYPBHkgICAgICAgIALXBgA2c8R5ICAgICAgICA',0);")
	
def createLevel(session, org, type, id, name, patentId):
	session.execute("insert into category(id,org,name,type,tagcount,deleted,lostMotionIntervalSeconds,lastUpdated,createdBy,datecreated, parentuuid) values("+ id +","+ org +",'"+ name +"','"+ type +"',0,false,0,1502394093118,'AANhcGkABmdsb2JhbLaImADYPBHkgICAgICAgIALXBgA2c8R5ICAgICAgICA',0, "+ patentId +");")

def main(org):
	cluster = Cluster()
	session = cluster.connect(KEYSPACE)

	#Create UUID Dynamically 
	idPeople = str(uuid.uuid1())
	idObject = str(uuid.uuid1())
	
	#create Root
	createRoot(session, org, idPeople, "People", "person")
	createRoot(session, org, idObject, "Object", "asset") 
	
	#create level 1 for people
	peopleType = "People-person"
	peopleLevel1Id = str(uuid.uuid1())
	peopleName1 = "People-1"
	createLevel(session, org, peopleType, peopleLevel1Id, peopleName1, idPeople)
	
	peopleLevel2Id = str(uuid.uuid1())
	peopleName2 = "People-2"
	createLevel(session, org, peopleType, peopleLevel2Id, peopleName2, idPeople)
	
	#Create Level 1 for Object
	objectType = "Object-Asset"
	objectLevel1Id = str(uuid.uuid1())
	objectName1 = "Object-1"
	createLevel(session, org, objectType, objectLevel1Id, objectName1, idObject)
	
	objectLevel2Id = str(uuid.uuid1())
	objectName2 = "Object-2"
	createLevel(session, org, objectType, objectLevel2Id, objectName2, idObject)
	
	objectUUID = []
	personUUID = []
	
	#Create Object hierarchy
	createCategory(session, org, objectType, objectName1, objectLevel1Id, objectUUID)
	createCategory(session, org, objectType, objectName2, objectLevel2Id, objectUUID)
	#Create People hierarchy
	createCategory(session, org, peopleType, peopleName1, peopleLevel1Id, personUUID)
	createCategory(session, org, peopleType, peopleName2, peopleLevel2Id, personUUID)
	
	#Create tags
	createTag(session, org, objectType, objectUUID, "Object tag - ")
	createTag(session, org, peopleType, personUUID, "People tag - ")
	
org = str(uuid.uuid1())

main(org)

print "DONE"
