
import sys

from DataManager import DataManager
from Logger import Logger

DataManager.getInstance().loadFiles()
DataManager.getInstance().hello()

logger = Logger.getLogger("logs")

logger.error("hatamesajiiii")
logger.info("infomesajii")

DataManager.getInstance().logCircleDeneme()
DataManager.getInstance().logCircleDeneme()
DataManager.getInstance().logCircleDeneme()


##  {
##    "advisorID": "165164",
##    "studentID": "150156156",
##    "schedule": {
##      "sessions": {
##        "CSE1502": "1"
##      },
##      "ID": "150156156",
##      "term": "Fall",
##      "termYear": "Senior"
##    },
##    "dateOfEntry": "2015-11-03",
##    "firstName": "İsim Örnek",
##    "lastName": "Soyisim Örnek"
##  }

## {
##   "studentID": "150156156",
##   "listOfSemesters": [
##     {}
##   ]
## }