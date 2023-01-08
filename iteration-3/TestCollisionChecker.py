import unittest
from CollisionChecker import CollisionChecker
#python -m unittest TestCollisionChecker.py
# cakisma varsa checker failledi yani false dondu
# cakisma yoksa checker ilerledi yani true dondu
class TestCollisionChecker(unittest.TestCase):

    
    def test_noschedule(self):
        #eger schedule yoksa cakisma olmaz
        schedule = [
            {"day":5,"timeStart":"13","timeEnd":"15"},
            {"day":6,"timeStart":"15","timeEnd":"17"},
            {"day":5,"timeStart":"9","timeEnd":"12"}
        ]
        schedule1 = [
        ]

        collision1 = CollisionChecker(schedule1,schedule)
        self.assertEqual(collision1.checkCollision(),False)

    def test_fcollisionTime(self):
        #saatlerin cakismasi lazim.
        schedule = [
            {"day":5,"timeStart":"15","timeEnd":"17"},
        ]
        schedule1 = [
            {"day":5,"timeStart":"13","timeEnd":"19"}
        ]

        collision1 = CollisionChecker(schedule1,schedule)
        self.assertFalse(collision1.checkCollision())
    
    def test_collisionDay(self):
        #gunler cakismiyosa saatlerin cakismamasi lazim
        schedule = [
            {"day":5,"timeStart":"15","timeEnd":"17"},
        ]
        schedule1 = [
            {"day":6,"timeStart":"15","timeEnd":"17"}
        ]

        collision1 = CollisionChecker(schedule1,schedule)
        self.assertFalse(collision1.checkCollision())    

    def test_tcollisionTime(self):
        #hicbir sey cakismiyor true donmeli
        schedule = [
            {"day":5,"timeStart":"13","timeEnd":"15"},
            {"day":6,"timeStart":"15","timeEnd":"17"},
            {"day":5,"timeStart":"9","timeEnd":"12"}
        ]
        schedule1 = [
            {"day":5,"timeStart":"12","timeEnd":"13"}
        ]

        collision1 = CollisionChecker(schedule1,schedule)
        self.assertFalse(collision1.checkCollision())

    def test_tcollisionTime2(self):
        #hicbir sey cakismiyor true donmeli
        schedule = [
            {"day":5,"timeStart":"12","timeEnd":"14"},
        ]
        schedule1 = [
            {"day":5,"timeStart":"11","timeEnd":"13"}
        ]
        collision1 = CollisionChecker(schedule1,schedule)
        self.assertFalse(collision1.checkCollision())
if __name__ == '__main__':
    unittest.main()
    print("Everything passed")