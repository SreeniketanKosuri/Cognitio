//
//  ViewController.swift
//  Quiz-FBLA
//
//  Created by Arez Khidr on 1/8/19.
//  Copyright © 2019 Arez Khidr. All rights reserved.
//

import UIKit
import Lottie

//Custom Swipe Animations
class SegueFromLeft: UIStoryboardSegue
{
    override func perform()
    {
        let src = self.source
        let dst = self.destination
        src.view.superview?.insertSubview(dst.view, aboveSubview: src.view)
        dst.view.transform = CGAffineTransform(translationX: -src.view.frame.size.width, y: 0)
        
        UIView.animate(withDuration: 0.25,
                       delay: 0.1,
                       options: [.curveEaseInOut],
                       animations: {
                        dst.view.transform = CGAffineTransform(translationX: 0, y: 0)
        },
                       completion: { finished in
                        src.present(dst, animated: false, completion: nil)
        }
        )
    }
}
class SegueFromRight: UIStoryboardSegue
{
    override func perform()
    {
        let src = self.source
        let dst = self.destination
        src.view.superview?.insertSubview(dst.view, aboveSubview: src.view)
        dst.view.transform = CGAffineTransform(translationX: +src.view.frame.size.width, y: 0)
        
        UIView.animate(withDuration: 0.25,
                       delay: 0.0,
                       options: [.curveEaseInOut],
                       animations: {
                        dst.view.transform = CGAffineTransform(translationX: 0, y: 0)
        },
                       completion: { finished in
                        src.present(dst, animated: false, completion: nil)
        }
        )
    }
}

class ViewController: UIViewController {
//Loading animation Outlet
    @IBOutlet weak var loadingAnimationView: LOTAnimationView!
    override func viewDidLoad() {
        super.viewDidLoad()
        startLoadingAnimation()
        Timer.scheduledTimer(withTimeInterval: 3, repeats: false, block: { (timer) in
            self.performSegue(withIdentifier: "loadingToHome", sender: ViewControllerHome.self)
        // Do any additional setup after loading the view, typically from a nib.\
        
    })

}
   // loadingAnimationView
    func startLoadingAnimation() {
        loadingAnimationView.setAnimation(named:"dotloader")
        loadingAnimationView.loopAnimation = true
        loadingAnimationView.play()
    }

}
