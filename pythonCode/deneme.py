
import sys

from DataManager import DataManager
from Logger import Logger

DataManager.getInstance().loadFiles()
DataManager.getInstance().hello()

logger = Logger.getLogger("denemelog")

logger.error("hatamesajiiii")
logger.info("infomesajii")

DataManager.getInstance().logCircleDeneme()
DataManager.getInstance().logCircleDeneme()
DataManager.getInstance().logCircleDeneme()
