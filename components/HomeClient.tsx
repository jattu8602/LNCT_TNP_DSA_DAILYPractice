'use client';

import { useEffect, useState, useRef } from 'react';
import { JavaFile } from '@/lib/getJavaFiles';
import CodeCanvas from '@/components/CodeCanvas';
import Lottie from 'lottie-react';
import {
  Carousel,
  CarouselContent,
  CarouselItem,
  CarouselNext,
  CarouselPrevious,
} from "@/components/ui/carousel";
import Autoplay from "embla-carousel-autoplay";

interface HomeClientProps {
  javaFiles: JavaFile[];
  recentFiles: JavaFile[];
  streak: number;
  totalSolved: number;
}

export default function HomeClient({ javaFiles, recentFiles, streak, totalSolved }: HomeClientProps) {
  const [fireAnimation, setFireAnimation] = useState(null);
  const [isPinned, setIsPinned] = useState(false);
  const autoplayRef = useRef(
    Autoplay({
      delay: 10000, // 10 seconds
      stopOnInteraction: false,
    })
  );

  useEffect(() => {
    // Load fire animation
    fetch('/animations/fire.json')
      .then((res) => res.json())
      .then((data) => setFireAnimation(data))
      .catch(() => console.log('Animation not found'));
  }, []);

  // Handle pin/unpin
  const handlePinToggle = () => {
    setIsPinned(!isPinned);
    const autoplay = autoplayRef.current;

    if (!isPinned) {
      // Pin it - stop autoplay
      autoplay.stop();
    } else {
      // Unpin it - resume autoplay
      autoplay.play();
    }
  };

  // Use all files if no recent files
  const filesToShow = recentFiles.length > 0 ? recentFiles : javaFiles;

  return (
    <div className="home-carousel-container">
      <Carousel
        opts={{
          align: "start",
          loop: true,
        }}
        plugins={[autoplayRef.current]}
        className="home-carousel-wrapper"
      >
        <CarouselContent>
          {filesToShow.map((file, index) => (
            <CarouselItem key={file.relativePath} className="carousel-full-item">
              <CodeCanvas
                file={file}
                index={index}
                isPinned={isPinned}
                onPinToggle={handlePinToggle}
              />
            </CarouselItem>
          ))}
        </CarouselContent>
        <CarouselPrevious className="carousel-nav-button" />
        <CarouselNext className="carousel-nav-button" />
      </Carousel>
    </div>
  );
}
