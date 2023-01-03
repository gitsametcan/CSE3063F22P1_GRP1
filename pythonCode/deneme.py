# from . import data
# from . import data
# from data import DataManager
import sys

# sys.path.append('../data')
from DataManager import DataManager
# sys.path.append('../logger')
from Logger import Logger

DataManager.getInstance().loadFiles()
DataManager.getInstance().hello()

# Logger.Logger.getLogger("denemelog").info("MERHABA")

logger = Logger.getLogger("denemelog")

logger.error("hatamesajiiii")
logger.info("infomesajii")

DataManager.getInstance().logCircleDeneme()
DataManager.getInstance().logCircleDeneme()
DataManager.getInstance().logCircleDeneme()