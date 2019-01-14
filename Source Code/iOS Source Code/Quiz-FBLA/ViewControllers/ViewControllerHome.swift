//
//  ViewControllerHome.swift
//  Quiz-FBLA
//
//  Created by Arez Khidr on 1/8/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import UIKit
import Lottie

class ViewControllerHome: UIViewController {
//Header Outlet and Hiding top rounded corners function
    @IBOutlet weak var headerView: UIView!
    func hideHeaderCorners() {
        self.headerView.layer.maskedCorners = [.layerMinXMaxYCorner, .layerMaxXMaxYCorner]
    }
    //Left and Right Swipe Animation Views and animations
    @IBOutlet weak var rightSwipe: LOTAnimationView!
    func startRightSwipeAnimation() {
        rightSwipe.setAnimation(named:"animation-w750-h450 (4)")
        rightSwipe.loopAnimation = true
        rightSwipe.play()
    }
    @IBOutlet weak var leftSwipe: LOTAnimationView!
    func startLeftSwipeAnimation() {
        leftSwipe.setAnimation(named: "animation-w750-h450 (5)")
        leftSwipe.loopAnimation = true
        leftSwipe.play()
    }
    override func viewDidLoad() {
        super.viewDidLoad()
        startRightSwipeAnimation()
        startLeftSwipeAnimation()
        hideHeaderCorners()
        
        // Do any additional setup after loading the view.
    }
    //Actions for Swiping to other View Controllers
    @IBAction func swipeToTrivia(_ sender: Any) {
        performSegue(withIdentifier: "homeToTrivia", sender: ViewControllerTrivia.self)
        
    }
    @IBAction func swipeToAttribution(_ sender: Any) {
        performSegue(withIdentifier: "homeToAttribution", sender: ViewControllerAttribution.self)
    }
}


